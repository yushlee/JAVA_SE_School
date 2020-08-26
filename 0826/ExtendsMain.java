package com.training.session4;

public class ExtendsMain {

	public static void main(String[] args) {
//		Father tony = new Father();
//		tony.父親的欄位 = "AUDI R8";
//		System.out.println(tony.父親的欄位);
		
		Child1 tom = new Child1();
		tom.兒子的欄位 = "TOYOTA";

		System.out.println(tom.兒子的欄位);
		System.out.println(tom.父親的欄位);
		tom.父親的方法();
		

		Child1 mark = new Child1("TOYOTA");
		System.out.println(mark.兒子的欄位);
	}

}
