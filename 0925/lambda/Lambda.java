package com.training.session7.lambda;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lambda {
	
	public static void main(String[] args) {
		
		
//		Integer sum = scores.stream().mapToInt(n -> Integer.parseInt(n)).sum();
		
		List<String> scores = new ArrayList<>();
		scores.add("1");
		scores.add("2");
		scores.add("3");
		scores.add("4");
		scores.add("5");
		
		Integer sum = scores.stream().mapToInt(n -> Integer.parseInt(n)).sum();
		System.out.println(sum);
		
		// Lambda 主要用來實作interface method(方法定義)使用匿名函式使的語法上更精簡!
		// Lambda 表示式必須含三部份:1.方法參數  2.箭頭符號  3.方法內容
		// Lambda 表達式透過把函式作為方法的參數傳遞,使的程式碼變的更加簡潔!
		
		// 匿名者類別宣告
		MathOperation operation = new MathOperation(){
			@Override
			public int operation(int firstParam, int secondParam) {
				return firstParam + secondParam;
			}			
		};
		operation.operation(2, 3);		
		

		
		
		// 參數宣告類型
		MathOperation addition = (int a, int b) -> a + b;
		// 參數不宣告類型(不需要特別宣告類型就可以識別參數)
		MathOperation subtraction = (a, b) -> a - b;
		// 大括號中回傳語句(用於當實作內容不只一行的時候)
		MathOperation multiplication = (a, b) -> {
			a += 1;
			b += 1;
			return a * b; 
		};
		// 做為方法參數方式傳入
		out.println("10 + 5 = " + operate(addition, 10, 5));
		out.println("10 - 5 = " + operate(subtraction, 10, 5));
		out.println("10 * 5 = " + operate(multiplication, 10, 5));
		
		// Lambda無參數無回傳實作
		Service service = () -> out.println("Java");
		service.nonReturnMethod();
		
		// Lambda vs Collection comparator
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(5);
		numbers.add(3);
		numbers.add(4);
		numbers.add(2);
		sortUseJava6(numbers);
		out.println("sortUseJava6:" + numbers);
		sortUseJava8(numbers);
		out.println("sortUseJava8:" + numbers);
		
		// Lambda Method references 方法參照
		// 運用參照方法的方式來定義 Lambda 方法實作(四種方式)
		
		// 1.方法是靜態(static)方法
		// 語法 -> ConcreteClassName :: staticMethodName
		String[] arr = { "a", "b", "c", "d", "e" };
		// Arrays.sort(arr, (a, b) -> Utility1.compareIgnoreCase(a, b));
		Arrays.sort(arr, Utility1 :: compareIgnoreCase);
		
		// 2.方法是實例(instance)方法，來自lambda表示式之「外」的參考變數
		// 使用 Lambda 表示式「外的參數」來達成
		// 語法 -> objectReference :: instanceMethodName 
		Utility2 util = new Utility2();
		// Arrays.sort(arr, (a, b) -> util.compare(a, b));
		Arrays.sort(arr, util :: compare);
		
		// 3.方法是實例(instance)方法，來自lambda表示式之「內」的參考變數
		// 使用 Lambda 表示式「內的參數」來達成
		// 語法 -> ObjectReferenceType :: instanceMethodName
		// 即為方法所傳入的參數物件自身方法
		// Arrays.sort(arr, (a, b) -> a.compareToIgnoreCase(b));
		Arrays.sort(arr, String :: compareToIgnoreCase);
		
		// 4.使用 new 呼叫(帶參數)建構子
		// 語法 -> ClassName :: new
		// Function<String, MethodReferenceNew> factory = (s) -> new MethodReferenceNew(s);
		Function<String, MethodReferenceNew> factory = MethodReferenceNew :: new;
		// 傳入建構子參數
		MethodReferenceNew funObj = factory.apply("use constructor to input");
		funObj.printX();
		
		// 使用 new 呼叫(不帶參數)建構子
		// Supplier<MethodReferenceNew> supplier = () -> new MethodReferenceNew();
		Supplier<MethodReferenceNew> supplier = MethodReferenceNew :: new;
		MethodReferenceNew supplierObj = supplier.get();
		supplierObj.setX("use constructor");
		supplierObj.printX();
	}
	
	private static int operate(MathOperation mathOperation, int firstParam, int secondParam){
		return mathOperation.operation(firstParam, secondParam);
	}
	
	private static void sortUseJava6(List<Integer> numbers){
		Collections.sort(numbers, new Comparator<Integer>() {
			@Override
			public int compare(Integer firstNumber, Integer secondNumber){
				return firstNumber.compareTo(secondNumber);
			}
		});
	}
	
	private static void sortUseJava8(List<Integer> numbers){
		Collections.sort(numbers, (n1, n2) -> n2.compareTo(n1));
	}

}

// 單一函式介面annotation
@FunctionalInterface
interface MathOperation {	
	// Lambda 限制僅具單一抽象方法的介面
	// 例如 Runnable、Callable、Comparator 皆是 FunctionalInterface
	int operation(int firstParam, int secondParam);
	
	 // Invalid '@FunctionalInterface' annotation; MathOperation is not a functional interface
//	  void otherMethod();
}

@FunctionalInterface
interface Service {
	void nonReturnMethod();
}

class Utility1 {
	static int compareIgnoreCase(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);
	}
}

class Utility2 {
	int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}
}

class MethodReferenceNew {
	String x;
	MethodReferenceNew() { }
	MethodReferenceNew(String x) {
		this.x = x;
	}	
	public void setX(String x) {
		this.x = x;
	}
	void printX() {
		System.out.println(x);
	}
}