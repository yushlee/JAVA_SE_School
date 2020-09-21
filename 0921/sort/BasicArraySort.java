package com.training.session6.collection.sort;

public class BasicArraySort {

	public static void main(String[] args) {
		// 指定一個不重複的整數數組，最後依數字由大到小排序
		// https://www.youtube.com/watch?v=TRK5FVwDIAI
		// 主排序:數字由小至大、次排序:字母由大至小
		String[] numbers = new String[] {"5D","2A","1D","6J","6A","4K","8J","4A","3D"};
		
		arraySorting(numbers);
		
		for(String number : numbers){
			System.out.println(number);
		}
	}
	
	public static void arraySorting(String[] numbers){
		for(int compareIdx = numbers.length - 1 ; compareIdx > 0 ; compareIdx--){
			for(int i = 0 ; i < compareIdx ; i++){
				String e1 = numbers[i];
				String e2 = numbers[i+1];
				if(compareElement(e1,e2)){
					numbers[i] = e2;
					numbers[i+1] = e1;
				}
			}
		}
	}

	private static boolean compareElement(String e1, String e2) {
		// 數字部份 
		Character n1 = e1.charAt(0);
		Character n2 = e2.charAt(0);
	    // 字母部份
		Character c1 = e1.charAt(1);
		Character c2 = e2.charAt(1);
		int numberResult = n1.compareTo(n2);
		int letterResult = c2.compareTo(c1);
		// 主排序:數字由小至大、次排序:字母由大至小
		int compareResult = (numberResult == 0) ? letterResult : numberResult;
		boolean isGreater = (compareResult > 0) ? true : false;		
		
		return isGreater;
	}

}
