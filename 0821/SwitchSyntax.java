package com.training.session3;

public class SwitchSyntax {

	public static void main(String[] args) {
		
		int number = 7;
		
		number = number - 3;
		
		switch (number) {
			case 8:
				System.out.println("Hello 8");
				break;
			case 7:
				System.out.println("Hello 7");
				break;
			case 6:
				System.out.println("Hello 6");
				break;
			default:
				System.out.println("Hello " + number);
		}
		

	}

}
