package com.training.session7.lambda.basicFI;

import java.util.function.Function;
import com.training.session7.lambda.Person;

public class FunctionDemo {
	public static void main(String[] args) {
		// 功能型(Function):將傳入的參數由T型別轉換成R型別後回傳
		// public interface Function<T, R>
		// R apply(T t);
		Function<Person, String> getNameFromPerson = p -> p.getName();
		/* use anonymous inner class:	
		Function<Person, String> getNameFromPerson = 
				new Function<Person, String>() {
					public String apply(Person p) {
						return p.getName();
					}
				};	
		*/
		for (Person p: Person.createList()) {
			System.out.println(getNameFromPerson.apply(p));
		}
	}
}
