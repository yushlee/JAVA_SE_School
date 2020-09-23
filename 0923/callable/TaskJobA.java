package com.training.session7.callable;

import java.util.concurrent.TimeUnit;

public class TaskJobA extends TaskJob {

	public TaskJobA(int endIndex) {
		super(endIndex);
	}

	@Override
	public ResultVo jobMethod() {
		int sum = 0;
		ResultVo resultVo = new ResultVo();
		resultVo.setTaskJobName("TaskJobA");		
		for(int index = 0 ; index <= endIndex ; index++){
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("TaskJobA index:" + index);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum += index;
		}
		resultVo.setResultNumber(sum);
		
		return resultVo;
	}

}
