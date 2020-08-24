package com.training.session4;

public class TwoArrayExp {

	public static void main(String[] args) {
		// [ 列數 ] [ 欄數 ] 
		String[][] twoArray = new String[2][3];
		// 第0列
		twoArray[0][0] = "A";
		twoArray[0][1] = "B";
		twoArray[0][2] = "C";
		// 第1列
		twoArray[1][0] = "D";
		twoArray[1][1] = "E";
		twoArray[1][2] = "F";
		
		
		
		System.out.println(twoArray[0][2]);
		String[] zeroRow = twoArray[0];
//		System.out.println(twoArray[0]);
		System.out.println("-----------------------------");
		
		System.out.println(twoArray.length);
		// i 列、 j 欄
		for(int i = 0 ; i < twoArray.length ; i++){
//			String[] row = twoArray[i];
//			System.out.println(row);
			for(int j = 0 ; j < twoArray[i].length ; j++){
				System.out.println(twoArray[i][j]);
			}
		}
		
		System.out.println("-----------------------------");
		
		// Enhance For Loop
		for(String[] oneArray : twoArray){
			for(String text : oneArray){
				System.out.println(text);
			}
		}
		
		
		int[][] numbers = new int[][] {
			{1,2,3,4,5},			
			{6,7,8,9},
			{10,11,12}
		};
	}

}
