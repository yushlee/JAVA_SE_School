package com.training.session7.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExp {

	public static void main(String[] args) {
		Date startTime = new Date();

		// 設定執行緒個數
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		// 預備要執行的任務清單
		List<TaskJob> toDoList = new ArrayList<TaskJob>();
		toDoList.add(new TaskJobA(10)); // 10 Second
		toDoList.add(new TaskJobB(5)); // 10 Second

		try {
			// 呼叫invokeAll，等threadPool中所有thread結束後才繼續
			// (Collection<? extends Callable<ResultVo>> tasks)
			List<Future<ResultVo>> futures = executorService.invokeAll(toDoList);
			int sum = 0;
			for (Future<ResultVo> future : futures) {
				ResultVo resultVo = future.get();
				sum += resultVo.getResultNumber();
				System.out.println("TaskJobName:" + resultVo.getTaskJobName());
				System.out.println("ResultNumber:" + resultVo.getResultNumber());
			}
			System.out.println("TaskJobA + TaskJobB = " + sum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}

		Date endTime = new Date();
		long difference = endTime.getTime() - startTime.getTime();
		System.out.println("Difference:" + difference  + " millisecond.");
	}

}
