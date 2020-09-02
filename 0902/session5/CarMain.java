package com.training.session5;

public class CarMain {

	public static void main(String[] args) {
		Child_1 tom = new Child_1();
		tom.driveCar("TOYOTA");
		
		Child_2 rita = new Child_2();
		rita.driveCar("Benz");
		
		Father father = new Father("BMW");
		// com.training.session5.Father@15db9742
		System.out.println(father.toString());
		
		
	}

}
