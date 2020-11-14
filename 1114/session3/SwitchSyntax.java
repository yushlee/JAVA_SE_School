package com.training.session3;

public class SwitchSyntax {
	public static void main(String[] args) {
//		然而switch 只需對應到符合其條件(case),不需每個條件(case)都走訪.
//		switch(變數名稱或運算式) { 
//		    case 符合數字或字元: 
//		                        陳述句一; 
//		         break; 
//		    case 符合數字或字元: 
//		                        陳述句二; 
//		         break; 
//		    default: 
//		                       陳述三; 
//		} 
        int score = 40;
        int level = score / 10; 
//		1.switch效率上比if判斷式來的好,因為if判斷式於執行時每一個判斷式都需走訪到.
//      2.switch 其參數 argument 於 Java 1.6 接受的參數型別:byte,short,int,char,與其相對應WrapperClass
//        Java 1.7 之後接受 String
//      3.case 不能重複
//      4.case value 是不可變的(final)
        
        final int no = 9;
        
//        no = no + 1;
        
        switch(level) { 
            case 10: 
            	System.out.println("得A");
            	break;
            case no: 
                System.out.println("得A"); 
                break; 
            case 8: 
                System.out.println("得B"); 
                break; 
            case 7: 
                System.out.println("得C"); 
                break; 
            case 6: 
                System.out.println("得D"); 
                break; 
            default: 
                System.out.println("得E(不及格)"); 
        }
        
        String text = "A";
        switch (text) {
			case "B":
				
				break;	
//			default:
//				break;
		}
        
	}
}
