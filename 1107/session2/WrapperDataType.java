package com.training.session2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WrapperDataType {
	public static void main(String[] args) {
        int a = 10;
        // Primitive data type 與  Wrapper class 之間的轉換
        // Primitive data type -> Wrapper class
        Integer intObj = a; // Auto-Boxing(自動裝箱)
        // Wrapper class -> Primitive data type 
        int b = new Integer(a); // Auto-UnBoxing(自動拆箱)
        System.out.println("10 > 9 compareTo:" + intObj.compareTo(9));
        System.out.println("10 = 10 compareTo:" + intObj.compareTo(10));
        System.out.println("10 < 11 compareTo:" + intObj.compareTo(11));
        
        // 字串轉int
        System.out.println( Integer.parseInt("2")+3 );
        
        // 參數一:放入要被轉為十進制的數值(二進制、八進制、十六進制) ; 參數二:放入參數一的進制
        System.out.println( Integer.parseInt("1000", 2) );
        
        // 進制轉換API
        int decimal = 10;
        System.out.println( "二進制:"+Integer.toBinaryString(decimal) );
        System.out.println( "八進制:"+Integer.toOctalString(decimal) );
        System.out.println( "十六進制:"+Integer.toHexString(decimal) );
        
		BigDecimal seven = new BigDecimal("7");
		BigDecimal three = new BigDecimal("3");
		BigDecimal two = new BigDecimal("2");
		// 加法
		System.out.println("7+3 = " + seven.add(three));
		// 減法
		System.out.println("7-3 = " + seven.subtract(three));
		// 乘法
		System.out.println("7*3 = " + seven.multiply(three));
		// 除法
		// (1)四捨五入 7/2 = 3.5
		System.out.println("7/2 = " + seven.divide(two, 0 ,RoundingMode.HALF_UP));
		// 7/3 = 2.3333..
		System.out.println("7/3 = " + seven.divide(three, 0 ,RoundingMode.HALF_UP));
		// (2)無條件捨去 7/2 = 3.5
		System.out.println("7/2 = " + seven.divide(two, 0 ,RoundingMode.DOWN));
		// (3)無條件進位 7/3 = 2.3333...
		System.out.println("7/3 = "  + seven.divide(three, 0 ,RoundingMode.UP));
		// 除法(取餘數)
		System.out.println("7%3 = " + seven.remainder(three));
		
		// String 物件作為引數傳入的建構函式能精確的構造出一個BigDecimal物件
		System.out.println(new BigDecimal("100.123"));
		System.out.println(new BigDecimal(100.123));
	}
}
