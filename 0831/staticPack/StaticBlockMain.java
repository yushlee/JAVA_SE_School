package com.training.session4.staticPack;

import static com.training.session4.staticPack.StaticBlock.staticMethod; // 靜態方法
import static com.training.session4.staticPack.StaticBlock.staticField; // 靜態欄位
import static java.lang.System.out;

public class StaticBlockMain {
	
	String instanceField;
	
	static String staticField1;
	
	public static void main(String[] args) {
		StaticBlock staticBlock = new StaticBlock();
//		System.out.println(instanceField);
		System.out.println(staticField1);
//		instanceMethod();
		staticMethod1();
		
		System.out.println("-------------------------");
//		System.out.println(StaticBlock.staticField); // 靜態欄位
//		StaticBlock.staticMethod(); // 靜態方法
		out.println(staticField);
		staticMethod();
	}
	
	public void instanceMethod(){
		
	}

	public static void staticMethod1(){
		
	}
	
}
