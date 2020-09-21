package com.training.session7.generics.before;

public class GenericsMain {

	public static void main(String[] args) {
		
		IntegerObject intNo = new IntegerObject();
		intNo.setNumber(3);
		
		BooleanObject value = new BooleanObject();
		value.setValue(true);
		
		
		GenericsObject n1 = new GenericsObject();
		n1.setValue(new Integer(77));
		
		Integer number = (Integer) n1.getValue();
		System.out.println(number);
		
		GenericsObject b1 = new GenericsObject();
		b1.setValue(true);
		
		Integer number2 = (Integer) b1.getValue();
		System.out.println(number2);
		
	}

}
