package com.dos.springboot.firstrestapi.user;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommanLineRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger( getClass() );
	
	private UserDetailsRepository repository;
	
	public UserDetailsCommanLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info( Arrays.toString( args ) );
		repository.save( new UserDetails( "DOS", "Admin" ) );
		repository.save( new UserDetails( "menosDOS", "Ayudante" ) );
		
//		List< UserDetails > users = repository.findAll();
		List< UserDetails > users = repository.findByRole( "Admin" );
		
		users.forEach( user -> logger.info( user.toString() ) );

	}

}
