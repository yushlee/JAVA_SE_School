package com.training.session7.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer> {
	
	// 資料分割的區間大小
	static final int DATE_MAX_LENGTH = 3;
	// 處理的資料「起始」、「結束」位置
	int startIdx, endIdx;
	// 原始來源資料
	int[] data;
	
	public SumTask(int[] data, int startIdx, int endIdx) {
		this.data = data;
		this.startIdx = startIdx;
		this.endIdx = endIdx;		
	}	

	@Override
	protected Integer compute() {
		int sum = 0;
		// endIdx 和 startIdx 差距小於 3 時進行加總運算
		if(endIdx - startIdx <= DATE_MAX_LENGTH){
			for(int i = startIdx ; i < endIdx ; i++){
				sum += data[i];
			}
			// System.out.println("startIdx:" + startIdx + " ~ endIdx:" + (endIdx-1) + " = " + sum);
			
			return sum;
		}else{
			// fork(分進)
//			System.out.println("fork [ start:" + (startIdx + DATE_MAX_LENGTH) + " end:" + endIdx + " ]");
			SumTask s1 = new SumTask(data,
									 startIdx + DATE_MAX_LENGTH,
									 endIdx);
			s1.fork();
			
			// 遞迴分割工作 compute(切割)
//			System.out.println("compute [ start:" + startIdx + " end:"+ (startIdx + DATE_MAX_LENGTH) + " ]");
			SumTask s2 = new SumTask(data,
					      			 startIdx,
					      			 startIdx + DATE_MAX_LENGTH);			
			
			System.out.println("join = " + s1.join());
			System.out.println("compute = " + s2.compute());
			System.out.println("combine (join + compute) = "+ (s1.join() + s2.compute()));
			System.out.println("------------------------------------------------");
			
			// s1(合擊) + s2(切割) = combine(合併)
			return s1.join() + s2.compute();
		}
	}	
}

public class RecursiveTaskExp {

	public static void main(String[] args) {
		ForkJoinPool p  = new ForkJoinPool(3);
		int data[] = {1,2,3,4,5,6,7,8,9,10};
		// 多執行緒環境下執行
		// 將1到10分批(三個元素為一批)先各別運算加總
		// 將各別分批計算後的結果最後再進行全部加總
		int sum = p.invoke(new SumTask(data, 0, data.length));
		System.out.println("Sum:" + sum);
	}

}
