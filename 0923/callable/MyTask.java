package com.training.session7.callable;

import java.util.concurrent.Callable;

public class MyTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 1 ; i <= 20 ; i++){
			Thread.sleep(500);
			System.out.println("MyTask:" + i);
			sum += i;
		}
		
		return sum;
	}

}
