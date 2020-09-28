package com.training.session7.lambda.advanceFI;

import java.util.List;
import java.util.function.BiPredicate;
import com.training.session7.lambda.Person;

public class BiPredicateDemo {
	public static void main(String[] args) {
		List<Person> pl = Person.createList();
		Person first = pl.get(0);
		String testName = "john";
		// public interface BiPredicate<T, U>
		// boolean test(T t, U u);
		BiPredicate<Person, String> nameBiPred = 
				(p, s) -> p.getName().equalsIgnoreCase(s);
		/* use anonymous inner class:	
		BiPredicate<Person, String> nameBiPred = 
					new BiPredicate<Person, String>() {
						public boolean test(Person p, String s) {
							return p.getName().equalsIgnoreCase(s);
						}
					}
		;	
		*/
		System.out.println("Is the first john? " 
							+ nameBiPred.test(first, testName));
	}
}
