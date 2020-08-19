package com.training.session2;

public class StringAPI {

	public static void main(String[] args) {
		
		// String str = new String("i Love Java");
		//            012345678910
		String str = "i Love Java";
		
		int no = str.length();
		System.out.println(no);		
		System.out.println(str.charAt(4));
		System.out.println(str.indexOf("J"));
		System.out.println(str.indexOf("a")); // 8
		System.out.println(str.lastIndexOf("a")); // 10
		System.out.println(str.contains("Love"));
		System.out.println(str.contains("love"));
		System.out.println(str.startsWith("i Love"));
		
		System.out.println(str.substring(3));
		System.out.println(str.substring(2,6));
		
		
		String name = "蔡宗痛";
		System.out.println(name.replace("宗", "X"));
		System.out.println(name);
		
		String name2 = "蔡祥祥";
		System.out.println(name2.replace("祥", "X"));
		System.out.println(name2.replaceFirst("祥", "X"));
		System.out.println(name2.replaceAll("祥", "X"));
		
		String text = "A,B,C,D";
		String[ ] texts = text.split(",");
//		System.out.println(texts);
		System.out.println(texts[0]);
		System.out.println(texts[1]);
		System.out.println(texts[2]);
		System.out.println(texts[3]);
	}

}
