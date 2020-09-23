package com.training.session7.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		// 準備 Callable工作清單
		List<Callable<Integer>> tasks = new ArrayList<>();
		tasks.add(new MyJob());
		tasks.add(new MyTask());		
				
		try {
			// 執行 Callable 所有工作
			List<Future<Integer>> results = executorService.invokeAll(tasks);
			int sum = 0;
			for(Future<Integer> result : results){
				int jobInt = result.get();
				System.out.println(jobInt);
				// 把各工作的各別計算結果做最後加總
				sum += jobInt;
			}
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			// 多執行緒服務關閉
			executorService.shutdown();
		}

	}
}
