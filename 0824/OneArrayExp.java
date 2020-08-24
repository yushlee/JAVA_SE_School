package com.training.session4;

public class OneArrayExp {

	public static void main(String[] args) {
		
//		String a = "A";
//		String b = "B";
//		String c = "C";
		
		// 陣列宣告
//		String[] texts;
		// 陣列實例化
//		texts = new String[5];
		
		String[] texts = new String[5];
		texts[0] = "A"; // 陣列給值
		texts[1] = "B"; // 陣列給值
		String b = texts[1]; // 陣列取值
		
//		texts = new String[10]; // 長度是靜態的
		
		System.out.println(texts[1]);
		
		// 實體化同時給予陣列元素初始值 
		String[] strs = new String[] {"A","B","C","D","E"};		
//		System.out.println(strs[4]); // ArrayIndexOutOfBoundsException
		System.out.println(strs[0]);
		System.out.println(strs[1]);
		System.out.println(strs[2]);
		System.out.println(strs[3]);
		System.out.println(strs[4]);
		
		System.out.println("---------------------------");
		
		int arraySize = strs.length;
		
		for(int i = 0 ; i < arraySize; i++){
			System.out.println(strs[i]);
		}
		
		System.out.println("---------------------------");
		
		// 增強型for loop
		for(String str : strs){
			System.out.println(str);
		}
		
	}

}
