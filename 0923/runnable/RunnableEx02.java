package com.training.session7.runnable;

public class RunnableEx02 {

	public static void main(String[] args) {
		// 匿名者類別撰寫方式
		new Thread(new Runnable(){
			public void run() {
		        for(int i=0;i<10;i++){
		            System.out.println("i =>" +  i + "=>" + Thread.currentThread().getName());
		        }
			}
		}).start();
		
//		myThread.start();
	}

}
