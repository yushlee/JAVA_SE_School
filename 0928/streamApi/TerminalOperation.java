package com.training.session7.lambda.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperation {

	public static void main(String[] args) {
		
		System.out.println("\n================= 終端作業 count() =================");
		// 終端作業 count()
		// 使用 count()方法回傳成員個數
		List<String> texts = new ArrayList<String>();
		texts.add("A");
		texts.add("B");
		texts.add("C");
		texts.add("D");
		texts.add("E");
		System.out.println("texts:" + texts);
		
		long count = texts.stream().count();
		System.out.println("count():" + count);
		
		System.out.println("\n================= 終端作業  max()、min() =================");
		// 終端作業 max()和 min()
		// 使用max()和 min()方法搭配Comparator的比較邏輯，得到最大值和最小值
		// Comparator<String> comparator = (t1 ,t2) -> t1.compareTo(t2);
		Comparator<String> comparator = String::compareTo;
		Optional<String> max = texts.stream().max(comparator);
		System.out.println("max():" + max.get());
		Optional<String> min = texts.stream().min(comparator);
		System.out.println("min():" + min.get());
		
		System.out.println("\n================= 終端作業 average()、sum() =================");
		// 終端作業 average()、sum()
		// Stream成員若要進行average()、sum()則必須是基礎型別的擴充型
		// ex:IntStream、LongStream、DoubleStream
		List<String> numbers = new ArrayList<>();
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		numbers.add("4");
		System.out.println("numbers:" + numbers);
		
		int sum = numbers.stream().mapToInt(n -> Integer.parseInt(n)).sum();
		System.out.println("sum():" + sum);
		
		OptionalDouble average = numbers.stream().mapToDouble(n -> Double.parseDouble(n)).average();
		System.out.println("average():" + average.getAsDouble());
		
		System.out.println("\n================= 終端作業 collect() List、Set、Map =================");
		// 終端作業 collect()
		// 將stream成員經過管線作業後的結果另存為 List、Set、Map
		String[] sArr = new String[] {"C", "D", "A", "B", "C", "D"};		
		Stream<String> s1 = Stream.of(sArr);
		
		// supplier(提供者):建立集合容器的提供者
		// accumulator(累加器):用於將元素加入集合中的方法
		// combiner(合併者):合併數個集合的方法
//		Set<String> set = s1.collect(HashSet::new, HashSet::add, HashSet::addAll);
		
		// <T> Stream element type
		// <A> the intermediate accumulation type of the Collector
		// 中間作業再新增元素時的資料型別
		// <R> the type of the result
		Set<String> set = s1.collect(Collectors.toSet());
		// 轉存 Set後，重複的字串自動移除
		set.stream().forEach(i -> System.out.print(i + " "));
		
		System.out.print("\n------------------\n");
		Stream<String> s2 = Stream.of(sArr);		
//		List<String> list = s2.collect(LinkedList::new, LinkedList::addFirst, LinkedList::addAll);
		List<String> list = s2.collect(Collectors.toList());
		// 轉存List後，所有字串保留
		list.stream().forEach(i -> System.out.print(i + " "));
		
		System.out.print("\n------------------\n");
		List<Person> persons = TestPerson.createPersonList();
		// Function<Person, String> keyMapper = person -> person.getName();
		Function<Person, String> keyMapper = Person::getName;
		Function<Person, Person> valueMapper = p -> p;	
		// 轉存Map，Key:Name Value:Person
		Map<String, Person> personMap = persons.stream().collect(Collectors.toMap(keyMapper, valueMapper));
		personMap.forEach(
			(name, person) -> System.out.format("Name:%s %s \n", name, person)			
		);
		
		System.out.println("\n================= 終端作業 collect() Collectors 進階操作 =================");
		// collect()搭配Collectors進階操作
		// 1.Collectors.averagingDouble
		// 將strem成員的特地屬性轉換成double並求得平均值
		Double averageAge =
				persons.stream().collect(Collectors.averagingDouble(person -> person.getAge()));
		System.out.println("averagingDouble():" + averageAge);
		
		// 2.joining()可將輸入的字串成員逐一附加一起
		List<String> sl = Arrays.asList("a", "b", "c", "d");
		// 將所有字串成員直接相連
		String s1Join = sl.stream().collect(Collectors.joining());
		System.out.println(s1Join);	
		// 指定字串成員相連時的「連結字串」
		String s2Join = sl.stream().collect(Collectors.joining("-"));
		System.out.println(s2Join);	
		// 指定字串成員相連時的「連結字串」，及連結後的「起頭」和「結尾」
		String s3Join = sl.stream().collect(Collectors.joining("-", "/*", "*/"));
		System.out.println(s3Join);
		
		// 3.groupingBy()可將stream的成員做分類		
		// 以Person的「年齡」為群組區分資料
		Function<Person, Integer> classifier = p -> p.getAge();
//		Function<Person, Integer> classifier = Person::getAge;
		Map<Integer, List<Person>> groupPersonByAge 
					= persons.stream().collect(Collectors.groupingBy(classifier));
		// Key:age,Value:personList
		groupPersonByAge.forEach(
				(age, personList) -> 
					System.out.format("Age %s: %s \n", age, personList)
		);
		
		// 4.partitioningBy()
		// 將stream的成員依條件搜尋後的結果儲存區分為兩組true/false資料(分組的key)
		Map<Boolean, List<Person>> partitioningPersonByAge = 
				persons.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 25));
				
		System.out.println("Is age > 25 ?");
		BiConsumer<Boolean, List<Person>> action = (k, v) -> System.out.println(
				k + ":\t" +
				v.stream()
				 .map(p -> p.getName())
				 .collect( Collectors.joining(","))
		);
		partitioningPersonByAge.forEach(action);				
 
	}

}
