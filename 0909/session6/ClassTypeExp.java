package com.training.session6;

public class ClassTypeExp {

	public static void main(String[] args) {
		// 具體類別
		Concrete concrete = new Concrete();
		concrete.concreteMethod();
		
		// 抽像類別
		// 不能直接實體化
		// Abstract abstractClass = new Abstract();
		Abstract abstractClass = new SubClass();
		abstractClass.abstractMethod();
	}

}

// Concrete Class (具體類別)
// 1.絕對具體：不允許任何抽象方法 (沒有實作內容的方法)
class Concrete {
	
	public void concreteMethod() {
		// 具體類別方法的實作內容
		System.out.println("concreteMethod");
	}
	
//	public abstract void abstractMethod();
}

// Abstract Class (抽象類別)
abstract class Abstract {
	// 半抽象半具體：抽象方法與具體方法(有實作內容的方法)並存
	public void concreteMethod() {
		// 具體類別方法的實作內容
		System.out.println("concreteMethod");
	}	
	 
	// 抽象方法
	public abstract void abstractMethod();
}

class SubClass extends Abstract {
	// The type SubClass must implement(實作) the inherited abstract method Abstract.abstractMethod()
	@Override
	public void abstractMethod() {
		System.out.println("abstractMethod");
	}
	
	
}
