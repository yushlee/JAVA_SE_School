package com.training.session4;

public class MainClass {

	public static void main(String[] args) {
		
		MethodClass methodClass = new MethodClass();		
//		methodClass.method(empNumber, empName, title);
		/*
		Employee emp = new Employee();
		emp.setEmpName("馬小九");
		emp.setEmpNumber(2);
		emp.setTitle("總痛");
		Employee tom = methodClass.method(emp);
		*/
		Employee emp = new Employee(123);
		System.out.println(emp.getEmpNumber());
		System.out.println(emp.getEmpName());
	}

}
