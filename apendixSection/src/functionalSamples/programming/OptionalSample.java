package functionalSamples.programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalSample {

	public static void main(String[] args) {
		List< String > fruits = List.of( "apple", "banana", "cherry" );
		Predicate< ? super String > predicate = fruit -> fruit.startsWith( "d" );
		
		Optional< String > optional = fruits.stream().filter( predicate ).findFirst();
		
		System.out.println( "Opt: " + optional );
		System.out.println( "Opt empty?: " + optional.isEmpty() );
		System.out.println( "Opt present?: " + optional.isPresent() );
		System.out.println( "Opt get: " + optional.get() );
	}

}
