package com.training.session3;

public class LoopSyntax {

	public static void main(String[] args) {
		

		
		for(int i = 1 ; i < 10 ;  i = i + 2 ) {
//			 重覆執行的事情
			System.out.println(i);
		}
		
		// 無窮迴圈
		for(int i = 0 ; i < 10 ; ) {
			System.out.println("Hello!");
			i++;
		}
		
//		for(int i = 0 ;  ; i++) {
//			System.out.println("Hello!");
//		}		
		
		// 初始變數
		int j = 0;
		// 條件式(前測試)
		while(j <= 5){
			System.out.println("Hello:" + j);
			// j++; // 遞增式
//			j = j + 3;
			j += 3;
		}
		
		int i = 0;
		do {
			System.out.println(i);
			i++;
		} while (i != 0);
		
	}

}
