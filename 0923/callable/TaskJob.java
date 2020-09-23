package com.training.session7.callable;

import java.util.concurrent.Callable;

public abstract class TaskJob implements Callable<ResultVo>{
	
	protected int endIndex;
	
	public TaskJob(int endIndex) {
		this.endIndex = endIndex;
	}
	
	// Callable 和 Runnable 不同的地方
	// 1.Callable call() method have return
	// 2.Callable call() method throws Exception
	@Override
	public ResultVo call() throws Exception {		
		return jobMethod();
	}
	
	public abstract ResultVo jobMethod();
}
