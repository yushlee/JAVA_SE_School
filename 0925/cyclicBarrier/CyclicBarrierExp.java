package com.training.session7.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;


//Step1:撰寫自訂義實作Runnable BarrierAction類別(路障要做的事)
class BarrierAction implements Runnable{
	public void run(){
		System.out.println("Barrier action...");
	}
}

class Worker extends Thread{
	
	CyclicBarrier cb;
	
	public Worker(CyclicBarrier cb){
		this.cb = cb;
	}
	
	public void run(){
		
		try {
			cb.await();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println("Thread Worker...");
	}
}


public class CyclicBarrierExp {

	public static void main(String[] args) {
		
		BarrierAction barrierAction = new BarrierAction();
		
		CyclicBarrier cb = new CyclicBarrier(3, barrierAction);
				
		Worker w1 = new Worker(cb);		
		Worker w2 = new Worker(cb);
		Worker w3 = new Worker(cb);
		
		w1.start();
		w2.start();
		w3.start();
		

		Worker w4 = new Worker(cb);		
		Worker w5 = new Worker(cb);
		Worker w6 = new Worker(cb);
		w4.start();
		w5.start();
		w6.start();
	}

}
