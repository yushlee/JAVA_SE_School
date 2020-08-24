package com.training.session3;

public class Triangle {
	
	public void printTriangle(int number){
		int spaceNo = number - 1;
		int starNo = 1;
		for(int i = 1 ; i <= number ; i++){
//			System.out.print(i + ":" + spaceNo + ":" + starNo);
			printSymbol(spaceNo, "X");
			printSymbol(starNo, "★");
			spaceNo--;
			starNo += 2;
			System.out.println();
		}		
	}
	
	public void printSymbol(int number, String Symbol){
		for(int i = 1 ; i <= number ; i++){
			System.out.print(Symbol);
		}
	}
}
