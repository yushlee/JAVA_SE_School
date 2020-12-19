package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

	public static void main(String[] args) {
		/*
		 給定一個非負整數  numRows，生成Pascal三角形(帕斯卡三角形)Pascal.gif
		 在Pascal三角形中，每個數字都是其正上方兩個數字的和
		 
		Input:6
		Output:
		[
		      [1]
		     [1,1]
		    [1,2,1]
		   [1,3,3,1]
		  [1,4,6,4,1]
		 [1,5,10,10,5,1]
		]
		*/
		
//		List<List<Integer>> pascals = generate(5);
//		for(List<Integer> pascal : pascals){
//			System.out.println(pascal);
//		}
		
		int[][] pascals = generate1(6);
		for(int[] pascal : pascals){
			for(int number : pascal){
				System.out.print(number + ",");
			}
			System.out.println();
		}
	}
	
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> pascal = new ArrayList<>();
    	for(int i = 0 ; i < numRows ; i++) {
    		List<Integer> numbers = new ArrayList<>();
    		for(int j = 0 ; j <= i ; j++){
    			// 每一列的"起始"、"結尾"都是1
    			if(j == 0 || j == i){
    				numbers.add(1);
    			}else{
    				// 中間數字為上層List的 [n - 1]+[n]
    				List<Integer> prePascal = pascal.get(i - 1);
    				int preNo = prePascal.get(j - 1);
    				int nextNo = prePascal.get(j);
    				numbers.add(preNo + nextNo);
    			}
    		}
    		pascal.add(numbers);
    	}    	
    	
    	return pascal;
    }
	
    public static int[][] generate1(int numRows) {
    	int[][] pascals = new int[numRows][];
    	for(int i = 1 ; i <= numRows ; i++){
    		int[] pascal = new int[i];
    		for(int j = 0 ; j < pascal.length ; j++){
	    		// 每一列的"起始"、"結尾"都是1
	    		if(j == 0 || j == pascal.length - 1){
	    			pascal[j] = 1;
	    		}else{
	    			// 取得上一列
	    			int[] prePascal = pascals[i - 2];
	    			// 中間數字為上一列的 [n - 1] + [n]
	    			pascal[j] = prePascal[j - 1] + prePascal[j];
	    		}
    		}
    		pascals[i - 1] = pascal;
    	}    	
    	
    	return pascals;
    }
    
    // 119. Pascal's Triangle II
    public static List<Integer> generate2(int rowIndex) {
    	List<List<Integer>> pascal = new ArrayList<>();
    	for(int i = 0 ; i < rowIndex + 1 ; i++) {
    		List<Integer> numbers = new ArrayList<>();
    		for(int j = 0 ; j <= i ; j++){
    			// 每一列的"起始"、"結尾"都是1
    			if(j == 0 || j == i){
    				numbers.add(1);
    			}else{
    				// 中間數字為上層List的 [n - 1]+[n]
    				List<Integer> prePascal = pascal.get(i - 1);
    				int preNo = prePascal.get(j - 1);
    				int nextNo = prePascal.get(j);
    				numbers.add(preNo + nextNo);
    			}
    		}
    		pascal.add(numbers);
    	}    	
    	
    	return pascal.get(rowIndex);
    }
}
