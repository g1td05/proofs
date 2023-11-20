package com.dos.spring.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
//		SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		MarioGame 	game 	= new MarioGame();
		GammeRunner runner 	= new GameRunner( game );
		runner.run(); 
	}

}
