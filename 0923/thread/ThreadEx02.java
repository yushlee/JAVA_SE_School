package com.training.session7.thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		
		System.out.println("Start =>" + Thread.currentThread().getName());
		
//		Step3： MyThread  myThread  =  new MyThread(  )
		MyThread myThread = new MyThread();		
//		Step4： myThread.start(  ) 　→　啟動執行緒		
		myThread.start(); // 必須引用呼叫start()才會開啟一個新的執行緒
//		myThread.run();
		
		System.out.println("End" + "=>" + Thread.currentThread().getName());
	}

}
/*
作法一：繼承 Thread
*/

// Step1：MyThread  extends Thread
class MyThread extends Thread {

	// Step2：@Override run(  ) method　→　執行緒要做的事
	@Override
	public void run() {
        for(int i=0;i<10;i++){
            System.out.println("i =>" +  i + "=>" + Thread.currentThread().getName());
        }
	}
	
}
