package com.training.session5.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExceptionCatchExp {
	public static void main(String[] args) {
		System.out.println("==================== Exception checked====================");
		// java.io.FileNotFoundException 檔案不存在例外錯誤
		// Unhandled exception type FileNotFoundException
		try {
			FileReader fr = new FileReader("C:/User.txt");
		} catch(FileNotFoundException fileNotFoundException) {
			System.out.println("找不到檔案!");
			System.out.println(fileNotFoundException.getMessage());
			fileNotFoundException.printStackTrace();
		} finally {
			System.out.println("FileNotFoundException finally !!!");
		}
		
		// java.lang.ClassNotFoundException 類別不存在例外錯誤
		// Unhandled exception type ClassNotFoundException
		try {
			Class account = Class.forName("com.training.session5.bank.finalPkg.Account");
		} catch(ClassNotFoundException classNotFoundException){
			System.out.println("找不到類別!");
			System.out.println(classNotFoundException.getMessage());
			classNotFoundException.printStackTrace();
		} finally {
			System.out.println("ClassNotFoundException finally !!!");
		}
		
		// Catch多個例外錯誤
		try {
			FileReader fr = new FileReader("C:/User.txt");
			Class account = Class.forName("com.training.session5.bank.finalPkg.Account");
		}  catch(FileNotFoundException fileNotFoundException) {
			System.out.println("找不到檔案!");
			System.out.println(fileNotFoundException.getMessage());
			fileNotFoundException.printStackTrace();
		} catch(ClassNotFoundException classNotFoundException){
			System.out.println("找不到類別!");
			System.out.println(classNotFoundException.getMessage());
			classNotFoundException.printStackTrace();
		} finally {
			System.out.println("FileNotFoundException finally !!!");
			System.out.println("ClassNotFoundException finally !!!");
		}
		
		// 必須先 catch 子類別例外錯誤再 catch 父類別例外錯誤
		try {
			FileReader fr = new FileReader("C:/User.txt");
			Class account = Class.forName("com.training.session5.bank.finalPkg.Account");			
		} catch(FileNotFoundException fileNotFoundException) {
			System.out.println("找不到檔案!");
			System.out.println(fileNotFoundException.getMessage());
			fileNotFoundException.printStackTrace();
		} catch(ClassNotFoundException classNotFoundException){
			System.out.println("找不到類別!");
			System.out.println(classNotFoundException.getMessage());
			classNotFoundException.printStackTrace();
		} catch (Exception exception){
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		// 不能任意 catch 尚未發生的 Exception 子類別例外錯誤
//		try {
//			
//		} catch(FileNotFoundException fileNotFoundException) {
			
//		}
		
		
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
		
		try {
			
		}catch (NullPointerException nullPointerException){
			System.out.println(nullPointerException.getMessage());
			nullPointerException.printStackTrace();
		}
	}
	
	public static void nullPointerException() {
		// java.lang.NullPointerException 空值指針例外錯誤
		// 可選擇是否明確處理
		// RuntimeException 其實不應該將例外錯誤Catch起來! 應該去修正來源程式
		try {
			String text = null;
//			if(text != null){
				System.out.println(text.length());
//			}
		}catch (NullPointerException nullPointerException){
			System.out.println(nullPointerException.getMessage());
			nullPointerException.printStackTrace();
		}
	}
	
	public static void arrayIndexOutOfBoundsException() {
		// java.lang.ArrayIndexOutOfBoundsException 超出陣列索引值範圍例外錯誤
		try {
			String[] texts = new String[1];
			texts[0] = "one";
			if(texts.length > 1){
				System.out.println(texts[1]);
			}
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();			
		}
		
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
