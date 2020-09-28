package com.training.session7.lambda.streamApi;

import java.util.ArrayList;
import java.util.List;

public class TestPerson {
	
	public static List<Person> createPersonList() {
		List<Person> people = new ArrayList<>();
		people.add(
			new Person.Builder()
			.name("Bob")
			.age(21)
			.email("bob@x.com")
			.build()	
		);
		people.add(
			new Person.Builder()
			.name("Jane")
			.age(25)
			.email("jane@x.com")
			.build()
		);
		people.add(new Person.Builder()
			.name("John").age(25).email("johnx.com").build());
		people.add(new Person.Builder()
			.name("Phil").age(55).email("phil@x.com").build());
		people.add(new Person.Builder()
			.name("Betty").age(85).email("betty@x.com").build());
		return people;
	}

}
