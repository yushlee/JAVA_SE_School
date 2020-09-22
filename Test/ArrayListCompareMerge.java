package com.training.session6.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArrayListCompareMerge {

	public static void main(String[] args) {		
		
		/*
			比較兩個List的元素內容(兩集合中數字不重覆且長度一致)
			{9,8,7,6,5,4}
			{6,5,4,3,2,1}
			輸出結果如下:
			第一列輸出(存在於"numbersOne"但不存在於"numbersTwo"的數字)
			[7, 8, 9]
			第二列輸出(存在於"numbersTwo"但不存在於"numbersOne"的數字)
			[1, 2, 3]
			第三列輸出(共同存在於"numbersOne"、"numbersTwo"的數字)
			[4, 5, 6]
			PS:輸出結果皆按數字升冪排序
		*/
		List<Integer> numbersOne = new ArrayList<>(Arrays.asList(new Integer[] {9,8,7,6,5,4}));
		List<Integer> numbersTwo = new ArrayList<>(Arrays.asList(new Integer[] {6,5,4,3,2,1}));
		

		
	}

}
