package com.training.session5.overrideMethod;

public class OverrideMethodExp {
	public static void main(String[] args) {
		Animal animal = new Fish();
		// 物件可操作的"欄位"、"方法"取決於所屬「型別」
		String animalField = animal.animalField;
		// compile error
//		 String fishField = animal.fishField;
		animal.breath();
	}
}

class Animal {
	
	public String animalField;
	
	// Static Method (行為依"型別"決定)
	static void breath() {
		System.out.println("Animal.用肺呼吸");
	}
	
	// Instance Method (行為依"物件"決定)
	// 有Override：執行子類別方法
	// 無Override：延用父類型方法
//	void breath() {
//		System.out.println("Animal.用肺呼吸");
//	}
}

class Fish extends Animal {
	
	public String fishField;
	
	static void breath() {
		System.out.println("Fish.用鰓呼吸");
	}
	
//	@Override
//	void breath() {
//		System.out.println("Fish.用鰓呼吸");
//	}
}