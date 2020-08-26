package com.training.session4;

public class Father {
	
	public String 父親的欄位;
	
//	public Father(){}
	
	public Father(){
		System.out.println("父親出生了  default!");
		父親的欄位 = "AUDI R8";
	}
	
	public Father(String car){
		System.out.println("父親出生了 String car!");
		父親的欄位 = car;
	}
	
	
	
	public void 父親的方法(){
		
	}
}
