package com.training.session4.level;

public class Employee {
	// (嚴)限制只允許相同 class 內存取
	private String privateField;
	
	// package-private 相同package內存取
	// default package 
	String packagePrivateField;
	
	// 受保護的
	protected String protectedField; 
	
	// (寬)無任何存取範圍限制
	public String publicField;
	
	public void fatherMethod(){
		System.out.println(this.privateField);
		System.out.println(this.packagePrivateField);
		System.out.println(this.protectedField);
		System.out.println(this.publicField);		
	}
}
