package com.training.session4.staticPack;

public class StaticBlock {
	
	public static String staticField = "staticField";
	
	public String instanceField = "instanceField";
	
	static {
		System.out.println("Run StaticBlock !!!");
		System.out.println(staticField);
//		System.out.println(instanceField);
		staticMethod();
//		instanceMethod();
	}
	
	public StaticBlock(){
		System.out.println("StaticBlock Class instance!!!");
	}
	
	public static void staticMethod(){
		System.out.println("staticMethod !!!");
	}
	
	public void instanceMethod(){
		System.out.println(staticField);
		System.out.println(instanceField);
		staticMethod();
		otherMethod();
	}
	
	public void otherMethod(){
		
	}
	
}
