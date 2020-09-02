package com.training.session5;

public class ReferenceCastingMain {

	public static void main(String[] args) {

//		downCasting();
		
//		upCasting();
		
		compileAndRunTime();
	}
	
	public static void downCasting(){
		// DownCasting (向下轉型)
//		Cat cat = new Cat();		
//		HelloKitty kitty = (HelloKitty) cat;
		
		// 上轉下(明確轉型)
		// java.lang.ClassCastException:
		// 父 → 子 Explicit (須明確轉型)
		HelloKitty kitty = (HelloKitty) new Cat();	
	}
	
	public static void upCasting(){
		// 子 → 父 Implicit (隱含)
//		HelloKitty kitty = new HelloKitty();
//		Cat cat = kitty;
		// UpCasting  (向上轉型)
		Cat cat = new HelloKitty();
		
		Animal animalOne = new Cat();
		Animal animalTwo = new HelloKitty();
	}
	
	public static void compileAndRunTime(){
		// 父
//		Cat cat = new Cat();
		// 子
//		HelloKitty kitty = (HelloKitty)cat;
//		kitty.sayHello();
		
		Cat cat = new HelloKitty();		
		HelloKitty kitty = (HelloKitty) cat;
		kitty.sayHello();
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