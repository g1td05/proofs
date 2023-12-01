package functionalSamples.programming;

import java.util.List;

public class Exercises {

	public static void main(String[] args) {
		
		System.out.println( "Ex1:\n" );
		List<Integer> numbers = List.of( 12, 9, 13, 4, 6, 2, 4, 12, 15 );
		printAllOddNumbers( numbers );
		System.out.println( "\nEx2:\n" );
		List<String> of = List.of( "Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes" );
		printAllCourses( of );
		System.out.println( "\nEx3:\n" );
		printAllWithSpringWord( of );
		System.out.println( "\nEx4:\n" );
		printAllCoursesAtLeast4( of );
		System.out.println( "\nEx5( followed ) exercise:\n" );
		printAllEvenSquareNumbersInList( numbers );
		System.out.println( "'nEx6:\n" );
		printSizeOfEach( of );
	}

	private static void printSizeOfEach( List< String > of ) {
		of.stream().map( ofi -> ofi.length() ).forEach( System.out :: println );
	}

	private static void printAllEvenSquareNumbersInList( List< Integer > numbers ) {
		numbers.stream().filter( number -> number %2 == 0 ).map( number -> number * number ).forEach( System.out :: println );
	}

	private static void printAllCoursesAtLeast4( List< String > of ) {
		of.stream().filter( ofi -> ofi.length() >= 4 ).forEach( System.out :: println );		
	}

	private static void printAllWithSpringWord( List< String > of ) {
		of.stream().filter( ofi -> ofi.contains( "Spring" ) ).forEach( System.out :: println );
		
	}

	private static void printAllCourses( List<String> of ) {
		of.stream().forEach( System.out :: println );		
	}

	private static void printAllOddNumbers( List<Integer> of ) {
		of.stream().filter( ofi -> ofi % 2 != 0 ).forEach( System.out :: println );
	}
	
	

}
