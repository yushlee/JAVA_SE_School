package com.training.session2;

public class Customer {
	
	public String maskName(String cusName){
		String name = "";
		
		// 取得顧客姓名的長度
		int cusLength = cusName.length();
		// 判斷式
		if(cusLength <= 2){
//			1.若顧客姓名為兩個字則隱碼第二個字
			System.out.println("兩個字");
			
		} else if(cusLength == 3) {
//			2.若為三個字則隱碼第二個字
			System.out.println("三個字");
			
		} else if(cusLength == 4) {
//			3.若為四個字則隱碼第二、第三個字
			System.out.println("四個字");
			
		} else if(cusLength > 4) {
//			4.若為四個字以上則一律隱碼第二、第三個字
			System.out.println("四個字以上");
			
		}
		
		
		// 姓名隱碼指定的位置
		
		
		
		return name;
	}
	
	
}
