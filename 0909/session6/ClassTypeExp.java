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
		
		// 介面
		// 不能直接實體化須透過其子類別來實作
//		Interface interfaceClass = new Interface();
		Interface interfaceClass = new SubClass2();
		interfaceClass.interfaceMethod1();		
		System.out.println(Interface.text);
		
		// The final field Interface.text cannot be assigned
//		Interface.text = "B";
		
		InterfaceB obj1 = new SubClassC();
		obj1.interfaceBMethod();
//		obj1.interfaceAMethod();
		
		InterfaceA obj2 = new SubClassC();
		obj2.interfaceAMethod();
//		obj2.interfaceBMethod();
		
		ConcreteA obj3 = new SubClassC();
		obj3.concreteA();
//		obj3.interfaceAMethod();
//		obj3.interfaceBMethod();
		
		SubClassC obj4 = new SubClassC();
		obj4.interfaceAMethod();
		obj4.interfaceBMethod();
		obj4.concreteA();
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
	
	public abstract void abstractMethod2();
}

class SubClass extends Abstract {
	// The type SubClass must implement(實作) the inherited abstract method Abstract.abstractMethod()
	@Override
	public void abstractMethod() {
		System.out.println("abstractMethod");
	}
	
	@Override
	public void abstractMethod2() {
		System.out.println("abstractMethod2");
	}	
}

// 介面
// 絕對抽象：不允許具體方法
interface Interface {
	
	// 常數(static 靜態、final 唯一、public 公開)
	String text = "A";
	
	// 介面方法
	public void interfaceMethod1();
	
	// 介面方法 abstract 修飾可省略
	public abstract void interfaceMethod2();
	
//	public void concreteMethod() {
		// 具體類別方法的實作內容
//		System.out.println("concreteMethod");
//	}
}


class SubClass2 implements Interface {

	@Override
	public void interfaceMethod1() {
		System.out.println("interfaceMethod1 !!!");
	}

	@Override
	public void interfaceMethod2() {
		
	}
	
}


interface InterfaceA{
	public void interfaceAMethod();
}

interface InterfaceB{ 
	public void interfaceBMethod();
}

class ConcreteA {
	public void concreteA(){
		System.out.println("concreteA");
	}
}
class ConcreteB {}

//  在Java語言中類別只能單一繼承類別，但可以實作多個介面 (先繼承後實作)
class SubClassC extends ConcreteA implements InterfaceA,InterfaceB {

	@Override
	public void interfaceAMethod() { 
		System.out.println("interfaceAMethod");
	}

	@Override
	public void interfaceBMethod() {
		System.out.println("interfaceBMethod");
	}
	
}
