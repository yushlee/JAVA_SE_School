package com.training.session7.lambda.basicFI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.training.session7.lambda.Person;

public class ConsumerDemo {
	public static void main(String[] args) {
		// 消費型(Consumer):使用泛型傳入參數，且沒有回傳(void)
		// public interface Consumer<T>
		// void accept(T t);
//		Consumer<Person> printPerson = p -> p.printPerson();
		
		// 方法是實例 (instance) 方法
		// 來自lambda表示式之「內」的參考變數
		 Consumer<Person> printPerson = Person::printPerson;
	
		/* use anonymous inner class: 	
		Consumer<Person> printPerson = new Consumer<Person>() {
			public void accept(Person p) {
				p.printPerson();
			}
		};	
		*/
		for (Person p: Person.createList()) {
			printPerson.accept(p);
		}
		
//		List<Person> peoples = new ArrayList<>();
//		peoples.add(new Person("Bob", "bob@x.com", 21));
//		peoples.add(new Person("Jane", "jane@x.com", 34));
//		peoples.add(new Person("John", "johnx@x.com", 25));
//		peoples.add(new Person("Phil", "phil@x.com", 65));
//		peoples.add(new Person("Betty", "betty@x.com", 55));
		
//		peoples.stream().forEach(p -> p.printPerson());
		

		
	}
}
