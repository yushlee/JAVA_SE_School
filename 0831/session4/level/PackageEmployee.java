package com.training.session4.level;

public class PackageEmployee {
	
	public void method(){
		Employee emp = new Employee();
//		System.out.println(emp.privateField);
		System.out.println(emp.packagePrivateField);
		System.out.println(emp.protectedField);
		System.out.println(emp.publicField);		
	}
}
