package com.training.session7.callable;

import java.util.concurrent.Callable;

public class MyJob implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 1 ; i <= 10 ; i++){
			Thread.sleep(1000);
			System.out.println("MyJob:" + i);
			sum += i;
		}
		
		return sum;
	}

}
