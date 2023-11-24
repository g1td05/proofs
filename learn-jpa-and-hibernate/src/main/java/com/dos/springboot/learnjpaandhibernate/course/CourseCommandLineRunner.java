package com.dos.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dos.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository jdbcRepo;
	
//	@Autowired
//	private CourseJpaRepository repo;
	
	@Autowired
	private CourseSpringDataJpaRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save( new Course( 1L, "Learn something", "D.O.S." ) );
		repo.save( new Course( 2L, "Learn nothing", "D.O.S." ) );
		repo.save( new Course( 3L, "Learn reading", "D.O.S." ) );
		
		repo.deleteById( 3L );
		
		System.out.println( repo.findById( 2L ) );
		
		System.out.println( repo.findByAuthor( "" ) );
		
		System.out.println( "------" );
		
		System.out.println( repo.findByAuthor( "D.O.S." ) );
	}

}
