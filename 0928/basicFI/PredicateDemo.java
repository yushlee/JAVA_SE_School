package com.training.session7.lambda.basicFI;

import java.util.function.Predicate;
import com.training.session7.lambda.Person;

public class PredicateDemo {
	public static void main(String[] args) {
		// 評斷型(Predicate):使用泛型傳入參數，且回傳 true/false
		// public interface Predicate<T>
		// boolean test(T t);
		Predicate<Person> olderThan23 = p -> p.getAge() >= 23;	
		/* use anonymous inner class:
		Predicate<Person> olderThan23 = new Predicate<Person>() {
			public boolean test(Person p) {
				return p.getAge() >= 23;
			}
		};	
		*/
		for (Person p : Person.createList()) {
			if (olderThan23.test(p)) {
				System.out.println(p);
			}
		}
	}
}
