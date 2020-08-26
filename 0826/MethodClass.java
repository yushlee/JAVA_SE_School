package com.training.session4;

public class MethodClass {
	
	public Employee method(Employee emp){
		
		String empName = emp.getEmpName();
		String title = emp.getTitle();
		int empNumber = emp.getEmpNumber();
		
		return emp;
	}
	
}
