package com.training.session5;

public class Child extends Father{
	
	// 1.同名、同參數 (型別、個數)
	// 2.存取修飾子：必須比父方法寬鬆或相等
	// 3.回傳型別：必須比父方法小或相等
	protected HelloKitty driveCar(String car){
		System.out.println("不要命的開:" + car);
		return new HelloKitty();
	}
	
}
