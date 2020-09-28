package com.training.session7.lambda.streamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ShortCircuitOperation {
	public static void main(String[] args) {
		// 這類作業方法以「搜尋」為主，搜尋時會以最小成本執行並結束工作
		
		// 短路型終端作業 allMatch()
		// 若所有成員滿足 Predicate 設置條件，則回傳 true
		// 一旦發現不滿足條件的成員則直接回傳 false，提前結束搜尋
		// 若stream為空，不會使用Predicate方法，直接回傳true
		List<String> names = new ArrayList<>();
		for(int i = 1 ; i <= 10 ; i++){
			names.add("Tom" + i);
		}
		
		Predicate<String> matchName = name -> name.contains("Tom");
		boolean matchResult = names.stream().allMatch(matchName);
		System.out.println("allMatch():" + matchResult);
		
		// 短路型終端作業 noneMatch()
		// 若所有成員都不滿足搜尋條件，則回傳true
		// 一旦發現滿足條件則直接回傳false，提前結束搜尋
		matchResult = names.stream().noneMatch(matchName);
		System.out.println("noneMatch():" + matchResult);
		
		// 短路型終端作業 anyMatch()
		// 找到任何一個成員符合條件則直接回傳true,搭配 parallelStream 為 deterministic(確定性)特性
		matchName = name -> name.equals("Tom3");
		matchResult = names.stream().anyMatch(matchName);
		System.out.println("anyMatch():" + matchResult);
		
		// 短路型終端作業 findFirst()、 findAny()
		// findFirst()方法找到第一個成員後回傳，若沒有成員則回傳 Optional empty		
		Optional<String> firstMemeber = names.stream().findFirst();
		System.out.println("findFirst():" + firstMemeber.get());
		
		// findAny()方法找到任何一個成員後回傳,搭配 parallelStream 為  Nondeterministic(非確定性)特性
		Optional<String> anyMemeber = names.stream().findAny();
//		Optional<String> anyMemeber = names.parallelStream().findAny();
		System.out.println("findAny():" + anyMemeber.get());
	}
}
