package com.training.session4;

// data model資料模型( 目的:儲存資料使用,沒有其它商業邏輯)
public class Employee {
	
	private int empNumber;
	private String empName;
	private String title;
	
	public Employee(){}
	
	public Employee(int number){
		this(number, "Tom");
	}
	
	public Employee(int empNumber, String name){
		// 區域變數:number
		// 成員變數:empNumber
//		empNumber = number;
		this.empNumber = empNumber;
		empName = name;
	}
	
	
	
	public Employee(int empNumber, String empName, String title) {
		this.empNumber = empNumber;
		this.empName = empName;
		this.title = title;
	}
	
	public void methodA(){
//		methodB();
		this.methodB();
	}
	
	public void methodB(){
		
	}
	
	public int getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
