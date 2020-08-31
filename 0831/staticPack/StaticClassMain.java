package com.training.session4.staticPack;

public class StaticClassMain {

	public static void main(String[] args) {
		StaticClass s1 = new StaticClass();
		s1.instanceField = "s1";
		System.out.println(s1.instanceField); // s1
		
//		s1.staticField = "s1";
//		System.out.println(s1.staticField);
		
		StaticClass s2 = new StaticClass();
		s2.instanceField = "s2";
		System.out.println(s2.instanceField); // s2
		System.out.println(s1.instanceField);
		
//		s2.staticField = "s2";
//		System.out.println(s2.staticField);
//		System.out.println(s1.staticField);
		
		System.out.println("======================");
		StaticClass.staticField = "s3";
//		StaticClass.instanceField = "s3";
		StaticClass.staticMethod();
//		StaticClass.instanceMethod();
		s2.instanceMethod();
		
	}

}
