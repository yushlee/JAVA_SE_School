package com.training.session7.lambda.basicFI;

import java.util.function.Supplier;
import com.training.session7.lambda.Person;

public class SupplierDemo {
	public static void main(String[] args) {
		// 供應型(Supplier):如同工廠方法，回傳T型別的實例/物件
		// public interface Supplier<T>
		// T get();
		 Supplier<Person> personSupplier = Person :: new; 
//		Supplier<Person> personSupplier = 
//				() -> new Person("New", "new@x.com", 21);
		/* use anonymous inner class:	
		Supplier<Person> personSupplier = new Supplier<Person>() {
			public Person get() {
				return new Person("New", "new@x.com", 21);
			}
		};	
		*/
		System.out.println(personSupplier.get());
	}
}
