package com.training.session5.exception;

public class TryCatch {

	public static void main(String[] args) {
		System.out.println("111");
		try {
			String text = null;
			System.out.println(text.length());
			System.out.println("222");
		} finally {
			System.out.println("333");
		}
		System.out.println("444");

	}

}
