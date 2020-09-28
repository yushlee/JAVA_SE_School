package com.training.session7.lambda.streamApi;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class ReductionMain {
	public static void main(String[] args) {
		// 將這些輸入的項目，經由逐一、反覆使用某結合功能後得到單一結果。
		// 因為過程會讓原先的輸入項目逐漸減少，故名「reduce」
		IntBinaryOperator intOperator = (sum, element) -> sum + element;
		int result = IntStream
					// 資料範圍
					.rangeClosed(1, 100)
					// 將處理後的單一結果儲存在  reduce的第一個參數identity
					.reduce(0, intOperator);
		
		System.out.println("Result = " + result);
			
		// 自訂義物件示例 Reduce
		List<Person> persons = TestPerson.createPersonList();
		Person person = new Person.Builder().build();
		BinaryOperator<Person> accumulator = (p1, p2) -> {
			int sumAge = p1.getAge() + p2.getAge();
			return new Person.Builder().age(sumAge).build();
		};
		person = persons.stream().reduce(person, accumulator);
		System.out.println("Person Sum = " + person.getAge());		
	}
}
