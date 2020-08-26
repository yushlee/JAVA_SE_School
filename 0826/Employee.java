package com.training.session4;

// data model資料模型( 目的:儲存資料使用,沒有其它商業邏輯)
public class Employee {
	
	private int empNumber;
	private String empName;
	private String title;
	
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
