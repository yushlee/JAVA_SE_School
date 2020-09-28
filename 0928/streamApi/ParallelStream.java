package com.training.session7.lambda.streamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {

	public static void main(String[] args) {
		// 1.由Collection(集合物件)使用parallelStream()方法
		parallelStreamingFromCollection();
		// 2.由Stream(串流物件)使用parallel()方法
		// parallelStreamingFromStream();
		// 3.管線操作的變數必須是「沒有狀態(stateless)」
		// statefullStreaming();
		// statelessStreaming();
	}
	
	public static void parallelStreamingFromCollection() {
		double sum = 
//				getEmps().stream()
				getEmps().parallelStream()
				.filter(e -> e.name.startsWith("Jim"))
				.filter(e -> e.salary >= 1500)
				.peek(e -> e.show())
				.mapToDouble(e -> e.salary)
				.sum();
		System.out.print(sum);
	}
	
	public static void parallelStreamingFromStream() {
		double sum = 
				getEmps().stream()
				.filter(e -> e.name.startsWith("Jim"))
				.filter(e -> e.salary >= 1500)
				.peek(e -> e.show())
				.mapToDouble(e -> e.salary)
//				.sequential()
				.parallel()
				.sum();
		System.out.print(sum);
	}
	
	public static void statefullStreaming() {
		// blockList有狀態(成員持續增加)，導致多執行緒無法分頭進行
		List<Emp> blockList = new ArrayList<>();		
		List<Emp> eList = getEmps();
		eList.parallelStream()
		.filter(e -> e.name.startsWith("Jim"))
		.forEach(e -> blockList.add(e));
	}
	
	public static void statelessStreaming() {
		// 透過改用collect()方法搭配Collectors.toList()，讓Java視需要自動調度何時建立List物件
		List<Emp> eList = getEmps();
		List<Emp> nonblockList = 
				eList.parallelStream()
				.filter(e -> e.name.startsWith("Jim"))
				.peek(e -> e.show())
				.collect(Collectors.toList());
	}
	
	private static List<Emp> getEmps() {
		List<Emp> es = new ArrayList<>();
		es.add(new Emp(1, "Jim1", 1000));
		es.add(new Emp(2, "Jim2", 2000));
		es.add(new Emp(3, "Jim3", 3000));
		es.add(new Emp(3, "Jjjj", 4000));
		return es;
	}
}

class Emp {
	double salary;
	int id;
	String name;
	Emp(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	void show() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(id + ",  " + name + ", " + salary);
	}
}

