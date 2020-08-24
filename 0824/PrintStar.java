package com.training.session3;

public class PrintStar {
	
	public void printTriangle(int number){
		/*
			*(1)
			**(2)
			***(3)
			****(4)
			*****(5)
			****(4)
			***(3)
			**(2)
			*(1)		
		 */
		
		for(int i = 1 ; i <= number ; i++){
//			System.out.println(i);
			printStar(i);			
		}
		
		for(int j = number - 1 ; j > 0 ; j--){
//			System.out.println(j);
			printStar(j);
		}
	}
	
	public void printStar(int number){
//		int number = 4;
		for(int i = 1 ; i <= number ; i++){
			System.out.print("*");
		}
		System.out.println();
	}
	
}
