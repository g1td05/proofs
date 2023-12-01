package functionalSamples.programming;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		List<Integer> of = List.of( 12, 9, 13, 4, 6, 2, 4, 12, 15 );
		printAllNumbersInListStructured( of );
		System.out.println( "..............." );
		printAllnumbersInListFunctional( of );
		System.out.println( "\nPrint Even structured...........\n" );
		printEvenNumbersInListStructured( of );
		System.out.println( "\nPrint Even functional...........\n" );
		printEvenNumbersInListFunctional( of );
	}

	private static void printAllNumbersInListStructured( List< Integer > numbers ) {
		for( int number:numbers ) {
			System.out.println( number );
		}
	}
	
	private static void printAllnumbersInListFunctional( List< Integer > numbers ) {
		numbers.stream().forEach( System.out::println );
	}
	
	private static void printEvenNumbersInListFunctional( List< Integer > numbers ) {
		numbers.stream().filter( number -> number % 2 == 0 ).forEach( System.out :: println );
	}
	

	private static void printEvenNumbersInListStructured( List< Integer > numbers ) {
		for( int number:numbers ) {
			if( number %2 == 0 ) {
				System.out.println( number );
			}
		}
	}

}
