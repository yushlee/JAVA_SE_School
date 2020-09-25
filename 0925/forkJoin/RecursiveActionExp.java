package com.training.session7.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class SumAction extends RecursiveAction {
	
	// 資料分割的區間大小
	static final int DATE_MAX_LENGTH = 3;
	// 處理的資料「起始」、「結束」位置
	int startIdx, endIdx;
	// 原始來源資料
	int[] data;
	
	public SumAction(int[] data, int startIdx, int endIdx) {
		this.data = data;
		this.startIdx = startIdx;
		this.endIdx = endIdx;		
	}	

	@Override
	protected void compute() {
		int sum = 0;
		// endIdx 和 startIdx 差距小於 3 時進行加總運算
		if(endIdx - startIdx <= DATE_MAX_LENGTH){
			for(int i = startIdx ; i < endIdx ; i++){
				sum += data[i];
			}
			System.out.println(sum);
		}else{
			// 分進 fork
			new SumAction(data,
						  startIdx + DATE_MAX_LENGTH,
						  endIdx).fork();
			
			// 遞迴分割工作 compute
			new SumAction(data,
					      startIdx,
					      startIdx + DATE_MAX_LENGTH).compute();
		}		
	}	
}

public class RecursiveActionExp {

	public static void main(String[] args) {
		ForkJoinPool p  = new ForkJoinPool();
		int data[] = {1,2,3,4,5,6,7,8,9,10};
		p.invoke(new SumAction(data, 0, data.length));
	}

}
