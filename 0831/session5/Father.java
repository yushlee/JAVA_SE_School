package com.training.session5;

public class Father {

	Cat driveCar(String car){
		System.out.println("慢慢的開:" + car);
		
		return new Cat();
	}
	
}


class Animal{
    public void eat(){
        System.out.println("Animal.eat");
    }
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