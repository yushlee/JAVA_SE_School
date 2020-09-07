package com.training.session5.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionThrowExp {

	public static void main(String[] args)  {
		
//		try {
//			checkedException();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		try {
			checkedException();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		nullPointerException();
		
		try {
			throwMethod();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void nullPointerException() throws NullPointerException {
		String text = null;
		System.out.println(text.length());
		
	}

	public static void checkedException() throws FileNotFoundException,ClassNotFoundException {
		
		FileReader fr = new FileReader("C:/User.txt");
		
		Class account = Class.forName("com.training.session5.bank.finalPkg.User");
		
	}
	
	public static void throwMethod() throws FileNotFoundException{
//		try {
			throw new FileNotFoundException();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	

}
