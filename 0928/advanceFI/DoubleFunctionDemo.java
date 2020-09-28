package com.training.session7.lambda.advanceFI;

import java.util.function.DoubleFunction;

public class DoubleFunctionDemo {
	public static void main(String[] args) {
		// public interface DoubleFunction<R>
		// R apply(double value);
		DoubleFunction<String> calc = t -> String.valueOf(t * 10);
		/* use anonymous inner class:	
		DoubleFunction<String> calc = new DoubleFunction<String>() {
			public String apply(double v) {
				return String.valueOf(v * 10);
			}
		};	
		*/
		String result = calc.apply(3.1415926D);
		System.out.println("New value is: " + result);
	}
}
