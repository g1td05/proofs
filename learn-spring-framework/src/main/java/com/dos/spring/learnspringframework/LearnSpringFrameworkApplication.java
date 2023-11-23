package com.dos.spring.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dos.spring.learnspringframework.game.GameRunner;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run( LearnSpringFrameworkApplication.class, args );
		
		GameRunner runner = context.getBean( GameRunner.class );
		
		runner.run();
		
//		GamingConsole marioGame  = new MarioGame();
//		GamingConsole contraGame = new SuperContraGame();
//		GamingConsole pacmanGame = new PacmanGame();
//		GameRunner runnerMario 	= new GameRunner( marioGame );
//		GameRunner runnerContra = new GameRunner( contraGame );
//		GameRunner runnerPacman = new GameRunner( pacmanGame );
//		runnerMario.run();
//		System.out.println( "Change game----------------" );
//		runnerContra.run();
//		System.out.println( "Change game----------------" );
//		runnerPacman.run();
	}

}
