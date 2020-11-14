package com.training.session3;

public class IfSyntax {
	public static void main(String[] args) {
		
//		Item1:單一判斷式
//		if(條件式)
//		    陳述句一;
//		else
//		    陳述句二;
		int score = 75;
		String text = "";
		if (score >= 60) {
			System.out.println("及格");
		} else {
			System.out.println("不及格");
		}
		
		System.out.println("---------------------------------------");
		
//		Item2:複合判斷式
//		if(條件式一) 
//		    陳述一; 
//		else if(條件式二) 
//		    陳述句二; 
//		else if(條件式三） 
//		    陳述句三; 
//		else 
//		    陳述句四;
        if(score >= 90) {
            System.out.println("得A");
        } else if(score >= 80 && score < 90) {
            System.out.println("得B");
        } else if(score >= 70 && score < 80) {
            System.out.println("得C");
        } else if(score >= 60 && score < 70) {
            System.out.println("得D");
        } else {
            System.out.println("得E(不及格)");
        }
        
        System.out.println("---------------------------------------");
        
//      Item3:三元運算子
//      DataType x = (條件判斷式) ? true-value : false-value;
        String result = score >= 60 ? "及格":"不及格";
        System.out.println(result);
	}
}
