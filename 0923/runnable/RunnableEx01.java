package com.training.session7.runnable;

public class RunnableEx01 {

	public static void main(String[] args) {
		
		System.out.println("Start =>" + Thread.currentThread().getName());
		
		// Step3：MyTask myTask = new MyTask( )
		MyTask myTask = new MyTask();
		// Step4：建立 Thread 並交付工作
		Thread myThread = new Thread(myTask); 
		// Step5：thrad.start(  ) 　→　啟動執行緒
		myThread.start();
		
		System.out.println("End" + "=>" + Thread.currentThread().getName());
	}

}
/*
作法二：實作 Runnable
*/

// Step1：MyTask implement Runnable
class MyTask implements Runnable {

	// Step2： @Override run(  ) method　→　執行緒要做的事
	@Override
	public void run() {
        for(int i=0;i<10;i++){
            System.out.println("i =>" +  i + "=>" + Thread.currentThread().getName());
        }		
	}
	
}