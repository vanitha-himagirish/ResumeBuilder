package com.project.springboot.resumebuilder;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ResumeBuilderApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
    @Autowired
    private UserProfileJDBCRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
    	
    	List<State>  userprofiles= userRepository.loadState();
    	
    	logger.info("All users -> {}", userprofiles.get(0).getStateName());
        logger.info("All states -> {}", userprofiles.get(1).getStateName());

    }

    
	public static void main(String[] args) {
		SpringApplication.run(ResumeBuilderApplication.class, args);
	}

}
