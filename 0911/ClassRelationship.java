package com.training.session6;

public class ClassRelationship {

	public static void main(String[] args) {
		

	}

}

class ConcreteClass {
	
}

abstract class AbstractClass{
	
	public abstract void abstractMethod();
	
}

interface InterfaceClass {
//	public void interfaceMethod();
}

//class ConcreteSubClass extends ConcreteClass{ }

//class ConcreteSubClass extends  AbstractClass {}

// "絕對具體"不能繼承"絕對抽象"
class ConcreteSubClass  implements  InterfaceClass{}



// "半抽象半具體"可以繼承"絕對具體"
//abstract class SubAbstractClass extends ConcreteClass {}

// "半抽象半具體" 可以繼承   "半抽象半具體"
// abstract class SubAbstractClass  extends AbstractClass{
	
	// 可以暫時不用強迫要覆寫(Override),因為本身就是個抽象類別
//	@Override
//	public void abstractMethod(){ }
	
//}

// 不須強迫實作介面方法可延遲實作
//abstract class SubAbstractClass  implements InterfaceClass{ }

// "絕對抽象" X "絕對具體"
// 不允許具體
// interface SubInterfaceClass extends ConcreteClass{ }

// "絕對抽象" X "半抽象半具體"
//interface SubInterfaceClass extends AbstractClass { }


//"絕對抽象" extends "絕對抽象"
interface SubInterfaceClass extends  InterfaceClass{
	
}
