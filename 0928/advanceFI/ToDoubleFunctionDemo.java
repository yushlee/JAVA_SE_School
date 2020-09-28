package com.training.session7.lambda.advanceFI;

import java.util.List;
import java.util.function.ToDoubleFunction;
import com.training.session7.lambda.Person;

public class ToDoubleFunctionDemo {
	public static void main(String[] args) {

		List<Person> pl = Person.createList();
		Person first = pl.get(0);
		// public interface ToDoubleFunction<T>
		// double applyAsDouble(T value);
		ToDoubleFunction<Person> convertAgeToDouble = p -> p.getAge();
		/* use anonymous inner class:	
		ToDoubleFunction<Person> convertAgeToDouble = 
				new ToDoubleFunction<Person>() {
					public double applyAsDouble(Person p) {
						return p.getAge();
					}
		};	
		*/
		System.out.println(convertAgeToDouble.applyAsDouble(first));
	}
}
