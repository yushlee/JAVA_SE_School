package com.training.session3;

public class MultiplyTable {

	public static void main(String[] args) {
		/*
			被乘數i 乘數j				   i    j
			2  *  2    2 * 3   2 * 4   2 -> 2,3,4
			3  *  2    3 * 3   3 * 4   3 -> 2,3,4
			4  *  2    4 * 3   4 * 4   4 -> 2,3,4
		*/
		
		for(int i = 2 ; i <= 9; i++){
			for(int j = 2 ; j <= 9; j++){
				System.out.print(i + "*" + j + "=" + (i * j) + "  ");
			}
			System.out.println();
		}
		
	}

}
