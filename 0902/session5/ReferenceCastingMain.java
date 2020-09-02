package com.training.session5;

public class ReferenceCastingMain {

	public static void main(String[] args) {
//		Cat cat = new Cat();
		// DownCasting (向下轉型)
//		HelloKitty kitty = (HelloKitty) cat;
		
		// 上轉下(明確轉型)
		// java.lang.ClassCastException:
		HelloKitty kitty = (HelloKitty) new Cat();
		
	}

}


class Animal{
    public void eat(){
        System.out.println("Animal.eat");
    }
}
class Dog extends Animal{
	
}
class Cat extends Animal{
    public void jump(){
        System.out.println("Cat.jump");
    }
}
class HelloKitty extends Cat{
    public void sayHello(){
        System.out.println("HelloKitty.sayHello");
    }
}