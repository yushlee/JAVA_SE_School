package com.training.session7.callable;

import java.util.concurrent.TimeUnit;

public class TaskJobB extends TaskJob {

	public TaskJobB(int endIndex) {
		super(endIndex);
	}

	@Override
	public ResultVo jobMethod() {
		int sum = 0;
		ResultVo resultVo = new ResultVo();
		resultVo.setTaskJobName("TaskJobB");		
		for(int index = 0 ; index <= endIndex ; index++){
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("TaskJobB index:" + index);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum += index;
		}
		resultVo.setResultNumber(sum);
		
		return resultVo;
	}


}
