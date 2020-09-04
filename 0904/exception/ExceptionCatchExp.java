package com.training.session5.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionCatchExp {
	public static void main(String[] args) {
		System.out.println("==================== Exception checked====================");
		// java.io.FileNotFoundException 檔案不存在例外錯誤
		// Unhandled exception type FileNotFoundException
		try {
			FileReader fr = new FileReader("C:/User.txt");
		} catch(FileNotFoundException fileNotFoundException) {
			System.out.println("哈哈找不到!");
			System.out.println(fileNotFoundException.getMessage());
			fileNotFoundException.printStackTrace();
		} finally {
			System.out.println("finally !!!");
		}
		
		// java.lang.ClassNotFoundException 類別不存在例外錯誤
		// Unhandled exception type ClassNotFoundException
//		Class account = Class.forName("com.training.session5.bank.finalPkg.Account");
//		System.out.println(account.getPackage());
		
		System.out.println("==================== RuntimeException unchecked====================");
		// java.lang.NullPointerException 空值指針例外錯誤		 
		nullPointerException();
		// java.lang.ArrayIndexOutOfBoundsException 超出陣列索引值範圍例外錯誤
		arrayIndexOutOfBoundsException();
		// java.lang.NumberFormatException 數值格式例外錯誤
		numberFormatException();
		// java.lang.ClassCastException 類別轉型錯誤
		classCastException();
	}
	
	public static void nullPointerException() {
		// java.lang.NullPointerException 空值指針例外錯誤
		String text = null;
		System.out.println(text.length());
	}
	
	public static void arrayIndexOutOfBoundsException() {
		// java.lang.ArrayIndexOutOfBoundsException 超出陣列索引值範圍例外錯誤
		String[] texts = new String[1];
		texts[0] = "one";
		System.out.println(texts[1]);
	}
	
	public static void numberFormatException() {
		// java.lang.NumberFormatException 數值格式例外錯誤
		String number = "java";
		Integer.parseInt(number);
	}
	
	public static void classCastException() {
		// java.lang.ClassCastException 類別轉型錯誤
		String str = "abc";
		Object object = str;
		Integer number = (Integer)object;
	}
}
