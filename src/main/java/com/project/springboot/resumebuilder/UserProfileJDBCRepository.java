package com.project.springboot.resumebuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;




@Repository
public class UserProfileJDBCRepository {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	class UserProfileRowMapper implements RowMapper < UserProfile > {
        @Override
        public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
        	UserProfile user = new UserProfile();
            user.setUserName(rs.getString("user_name"));
            user.setFirstName(rs.getString("user_fname"));
            user.setLastName(rs.getString("user_lname"));
            user.setMiddleName(rs.getString("user_mname"));
            user.setPassword(rs.getString("user_password"));
            user.setAddress(rs.getString("user_Address"));
            user.setAddress1(rs.getString("user_Address2"));
            user.setCity(rs.getString("user_City"));
            user.setStateID(rs.getInt("user_State"));
            user.setZipcode(rs.getString("user_Zipcode"));
            return user;
        }
      }
	
	public class stateRowMapper implements RowMapper<State> {
		@Override
		public State mapRow(ResultSet rs, int rowNum) throws SQLException {
        	State st = new State();
            st.setStateID(rs.getInt("state_id"));
            st.setStateName(rs.getString("state_name"));
           return st;
                     
        }
		
}
	public List<State> loadState() {
		//return jdbcTemplate.query("select state_id,state_name from state", new stateRowMapper());
		 String sql = "select state_id,state_name from state";
		  // RowMapper<State> rowMapper = new stateRowMapper();
		// String stquery = "SELECT * FROM state";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			List<State> result = new ArrayList<State>();
			for(Map<String, Object> row:rows){
				State st = new State();
	            st.setStateID((int)row.get("state_id"));
	            st.setStateName((String)row.get("state_name"));
				result.add(st);
			}
			return result;		
	}
	
	public List < UserProfile > findAll() {
        return jdbcTemplate.query("select * from user_profile", new UserProfileRowMapper());
    }
	public Optional < UserProfile > findByUName(String userName) {
        return Optional.of(jdbcTemplate.queryForObject("select * from user_profile where usr_name=?", new Object[] {
                userName
            },
            new BeanPropertyRowMapper < UserProfile > (UserProfile.class)));
    }
	 public int deleteByUName(String userName) {
	        return jdbcTemplate.update("delete from user_profile where userName=?", new Object[] {
	        		userName
	        });
	 }
	 public int insert(UserProfile user) {
	        return jdbcTemplate.update("insert into user_profile (user_name, user_fname, user_lname, user_mname,user_password,user_Address,user_Address2,user_City,user_State,user_Zipcode) " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
	            new Object[] {
	            		user.getUserName(), user.getFirstName(), user.getLastName(), user.getMiddleName(), user.getPassword(),user.getAddress(),user.getAddress1(),user.getCity(),user.getStateID(),user.getZipcode()
	            });
	    }
	 public int update(UserProfile user) {
	        return jdbcTemplate.update("update user_profile " + " set user_fname = ?, user_lname = ?, user_mname = ? ,user_password=?" + " where id = ?",
	            new Object[] {
	            		user.getFirstName(), user.getLastName(), user.getMiddleName(), user.getPassword(),user.getUserName()
	            });
	    }
	 
	 
}
