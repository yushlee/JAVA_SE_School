package com.training.session5;

public class Father {
	
	public String car;
	
	public Father() {}
	
	public Father(String car){
		this.car = car;
	}
	
	Cat driveCar(String car){
		System.out.println("慢慢的開:" + car);		
		
		return new Cat();
	}

	@Override
	public String toString() {
		return "Father [car=" + car + "]";
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