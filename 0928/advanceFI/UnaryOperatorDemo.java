package com.training.session7.lambda.advanceFI;

import java.util.List;
import com.training.session7.lambda.Person;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
	public static void main(String[] args) {
		List<Person> pl = Person.createList();
		Person first = pl.get(2);		
		// public interface Function<T, R>
		// R apply(T t);
		// public interface UnaryOperator<T> extends Function<T, T>
		// T apply(T t);
		UnaryOperator<String> unaryStr = s -> s.toUpperCase();
		/* use anonymous inner class:
		UnaryOperator<String> unaryStr = new UnaryOperator<String>() {
			public String apply(String s) {
				return s.toUpperCase();
			}
		};	
		*/
		System.out.println("Before: " + first.getName());
		System.out.println("After: " + unaryStr.apply(first.getName()));
	}
}
