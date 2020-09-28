package com.training.session7.lambda.streamApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediateOperation {
	public static void main(String[] args) throws IOException {
		System.out.println("\n================= 中間作業  filter() =================");
		// 中間作業  filter()
		// 方法用來篩選出所要的資料成員，使用"Predicate"介面的實作物件作為參數
		// 傳入集合中的成員透過自訂義判斷式回傳boolean濄濾篩選出所要的目標資料成員
		List<Object> objs = Arrays.asList("1",2,"3",4,"5",6,"7");
		Stream<Object> objsStream = objs.stream();
		// public interface Predicate<T>
		// boolean test(T t);
		Predicate<Object> isString = o -> o instanceof String;
		objsStream.filter(isString).forEach(o -> System.out.println(o));
		
		System.out.println("\n================= 中間作業  map() =================");
		// 中間作業  map()
		// 方法來轉換資料成員，使用Function介面的實作物件作為參數
		// 表示要對資料成員用的方法是「傳入某型別，經過某些流程後，回傳另一種型別」
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		Stream<Integer> intStream = numbers.stream();
		// public interface Function<T, R>
		// R apply(T t);
		Function<Integer, Float> mapper = n -> n * 1.5f;
		Stream<Float> floatNoStream = intStream.map(mapper);
		// Stream成員一旦被使用過，就不能再被使用了，immutable(不可改變)
		// java.lang.IllegalStateException: stream has already been operated upon or closed
		// floatNoStream = intStream.map(mapper);
		
        IntFunction<Float[]> generator = size -> new Float[size];
		Float[] floatNos = floatNoStream.toArray(generator);		
		for(float floatNo : floatNos){
			System.out.println(floatNo);
		}
		
		System.out.println("\n================= 中間作業  mapToInt() =================");
		
		// map()方法相關「基本型別」擴充版
		// mapToInt()、mapToLong()、mapToDouble()
		List<String> texts = Arrays.asList("A1","A2","A3");
		// public interface ToIntFunction<T>
		// int applyAsInt(T value);
		ToIntFunction<String> intFun = Integer::parseInt;
		texts.stream()
			 .map(s -> s.substring(1))
			 .mapToInt(intFun)
			 .forEach(no -> System.out.print(no + ", "));
		
		System.out.println("\n================= 中間作業  peek() =================");
		
		// 中間作業 peek()
		// 使用peek方法主要用來「窺視」debug 當 stream 成員經過其它「中間作業」後的中間變化過程
		// 使用Consumer介面可以傳入參數且沒有回傳
		// 若stream沒有定義「終端作業」ex:forEach，peek()將不會啟用執行
//		Function<String, String> toUpperCase = text -> text.toUpperCase();
		Function<String, String> toUpperCase = String::toUpperCase;
		texts = Arrays.asList("a","aa","aaa","aaaa");
		texts.stream()
			 .filter(text -> text.length() >= 3)
			 .peek(text -> System.out.println("Filter value:"+ text))
			 .map(toUpperCase)
			 .peek(text -> System.out.println("UpperCase value:"+ text))
			 .forEach(System.out::println);
		
		System.out.println("\n================= 中間作業  sorted() =================");
		
		// 中間作業 sorted()
		// 將Stream成員依「Comparator定義的順序」重新排序
		texts = Arrays.asList("B","D","A", "E", "C");		
		// Comparator<String> comparator = (t1, t2) -> t2.compareTo(t1);
		// public interface Comparator<T>
		// int compare(T o1, T o2);
		Comparator<String> comparator = String::compareTo;
		texts.stream()
			 .sorted(comparator)
			 .forEach(System.out::print);
		
		System.out.println("\n================= 中間作業  sorted() thenComparing =================");
		// 搭配Comparator進行多段式排序
		List<Person> persons = TestPerson.createPersonList();
		// public interface Function<T, R>
		// R apply(T t);
		// Function<Person, Integer> getPersonAges = person -> person.getAge();
		Function<Person, Integer> getPersonAges = Person::getAge;
		Function<Person, String> getPersonNames = Person::getName;
		
		// 先依Age升幕排序後(comparing)、再依name英文字母升幕次排序(thenComparing)
		Comparator<Person> comp = 
				Comparator.comparing(getPersonAges)
						  .thenComparing(getPersonNames);			
		
		persons.stream()
			.sorted(comp)
			.forEach(s -> System.out.println(s));
		
		System.out.println("\n================= Comparator reversed() =================");
		
		// reversed 將比較結果倒置
		persons.stream()
			.sorted(comp.reversed())
			.forEach(s -> System.out.println(s));
		
		System.out.println("\n================= 中間作業  flatMap() =================");
		
		// 中間作業  flatMap()
		// 以stream的形式展開/呈現，因此有層層展開，將之攤平(flat)的效果
		// 範例將兩個資料集合與之攤平合併在一起
		List<Integer> list1 = Arrays.asList(10, 20);
		List<Integer> list2 = Arrays.asList(30, 40);
		
		Function<List<Integer>, Stream<Integer>> flatMapper = list -> list.stream(); 
		Stream.of(list1, list2)
			  .flatMap(flatMapper)
			  .forEach(s -> System.out.print(s + " "));
		
		System.out.println("\n================= 中間作業  NIO flatMap() =================");
		
		// 來源為資料檔案
		Path p = Paths.get("dir/session7/flatMap.txt")
				.toAbsolutePath();
		/*
		Function<String, Stream<String>> mapper = 
				new Function<String, Stream<String>>() {
					public Stream<String> apply(String line) {
						return Stream.of(line.split(" "));
					}
				};
		*/		
		
		Stream<String> fileStream = Files.lines(p);
		Function<String, Stream<String>> fileFunction = line -> Stream.of(line.split(" "));
		
		long matches =  fileStream
						//.peek(System.out::println) // 原始檔案資料文字
						.flatMap(fileFunction)	
						//.peek(System.out::println) // 將原始每行文字以空白切割後整合成Stream<String>
						.filter(word -> word.equals("book"))
						//.peek(System.out::println) // 將有符合book文字印出
						.count();
		
		// 印出符合book文字數量
		System.out.println("\"book\" of Matches: " + matches);
	}
}
