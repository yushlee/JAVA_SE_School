package com.training.session4;

import com.training.session4.level.Employee;

public class SubEmployee extends Employee{

	public void method(){
		SubEmployee subEmp = new SubEmployee();
//		System.out.println(subEmp.privateField);
//		System.out.println(subEmp.packagePrivateField);
		System.out.println(subEmp.protectedField);
		System.out.println(subEmp.publicField);
		
		subEmp.fatherMethod();
		
		// 預設繼承物件之母 java.lang.Object
		subEmp.hashCode();
		subEmp.equals("");
	}
	
	

}
