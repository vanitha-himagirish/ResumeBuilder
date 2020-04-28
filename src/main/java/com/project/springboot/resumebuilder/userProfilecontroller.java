package com.project.springboot.resumebuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class userProfilecontroller {
	@Autowired
    private UserProfileJDBCRepository userRepository;
  //  private stateJDBCRepository stateRep;

	@RequestMapping("/userprofile")
	public String  welcome() {
		return "userprofile";
	}
	
	@PostMapping("/userprofile_submit")
	 public String saveDetails(@RequestParam("txtUserName") String userName,
             @RequestParam("txtFirstName") String FirstName,
             @RequestParam("txtLastName") String LastName,
             @RequestParam("txtMiddleName") String MiddleName,
             @RequestParam("txtPassword") String Password,
             @RequestParam("txtAddress") String Address,
             @RequestParam("txtAddress2") String Address2,
             @RequestParam("txtCity") String City,
             @RequestParam("cmbState") int State,
             @RequestParam("txtZip") String Zip

             ) {
		 userRepository.insert(new UserProfile(userName, FirstName , LastName, MiddleName ,Password, Address, Address2, State,City, Zip ));
		 return "userprofile";
	 }
	
	 @ModelAttribute("states")
	 public Map<String,String> loadStates() {
			List<State>  userprofiles= userRepository.loadState();
	        Map<String,String> states = new LinkedHashMap<String,String>();
	        for (int i=0; i<userprofiles.size(); i++) 
	        { 
	        	states.put(Integer.toString(userprofiles.get(i).getStateID()), userprofiles.get(i).getStateName());
	        }
	       return states;
	    }
}
