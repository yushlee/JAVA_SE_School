package session2;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrimitiveDataType {	
	public static void main(String[] args){
		
		// 整數(沒有小數點)
//		byte 位元 8-bit (-2^7 ~ 2^7-1)
		byte byteNumber = 12;
		
		Byte byteNo = new Byte(byteNumber);
		
//		short 短整數 16-bit (-2^15 ~ 2^15-1)
		short shortNumber = 13;		
		Short shortNo = new Short(shortNumber); 
		
//		int 整數 32-bit (-2^31 ~ 2^31-1)
		int intNumber = 14;
				
		int no = Integer.parseInt("2") + 2;		
		System.out.println(no);
		
		Integer ten = new Integer(10);
		Integer three = new Integer(3);
		int result = ten.compareTo(three);
		System.out.println(result);
		
		result = three.compareTo(ten);
		System.out.println(result);
		

		result = ten.compareTo(ten);
		System.out.println(result);
		
		// auto-Boxing 自動裝箱
		// 原始資料型別 -> 包裝類別
//		Integer intVal = new Integer(99);
		Integer intVal = 99;
		
		// auto-UnBoxing 自動拆箱
		// 包裝類別 -> 原始資料型別
		int intNo = new Integer(10);
		
		
//		long 長整數 64-bit (-2^63 ~ 2^63-1)
		long longNumber = 15;
		Long longNo = new Long(15);
		
		
		// 小數位
//		float 浮點數 32-bit
		float floatNumber = 0.65F;
		Float floatNo = new Float(12.2);  
		
//		double 倍精度浮點數 64-bit
		double doubleNumber = 0.75D;
		Double doubleNo = new Double(11.22);
		
		// char(字元) 	數值範圍：0 ~ 65535
		char text = 'A';
		
		char a = 65;
		Character character = new Character('B'); 
		System.out.println(a);
		
		char A = 97;
		System.out.println(A);
		
		char exclamationMark = 33;
		System.out.println(exclamationMark);
		
		char tab = '	';
		System.out.println( (int)tab );
		
		boolean valT = true;
		boolean valF = false;
		
		Boolean bVal = true;
		
		// 薪資
		int n1 = 31000;
		// 標準
		int n2 = 100000;
		boolean greaterThan = (n1 > n2);
		if(greaterThan){
			System.out.println("嫁給他");
		}else{
			System.out.println("不嫁");
		}
		
		// 整數
//		int avgNumber = 7 / 3;
		double avgNumber = (double) 7 / 3;
		System.out.println("avgNumber:" + avgNumber);

		
		BigDecimal seven = new BigDecimal("7");
		BigDecimal bThree = new BigDecimal("3");
		BigDecimal two = new BigDecimal("2");
		
		System.out.println(seven.add(bThree));
		System.out.println(seven.subtract(bThree));
		System.out.println(seven.multiply(bThree));
		
		// 進制捨去(無條件捨去)
		System.out.println(seven.divide(bThree, 2, RoundingMode.DOWN));
		
		// 進制捨去(無條件進位)
		System.out.println(seven.divide(bThree, 2, RoundingMode.UP));
		
		// 進制捨去(四捨五入)
		System.out.println(seven.divide(bThree, 2, RoundingMode.HALF_UP));
		
		
		
		// BigDecimal實例化時候請使 "字串" String
		System.out.println(new BigDecimal("100.123"));
		System.out.println(new BigDecimal(100.123));
		
		// 字串 轉 數字
		int number = Integer.parseInt("123");
		System.out.println(number + 2);
		// 數字 轉  字串
		String noStr = String.valueOf(number);
		System.out.println(noStr + 2);
		
	}
}
