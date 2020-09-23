package com.training.session7.runnable;

public class RunnableEx03 {
	public static void main(String[] args) {
        Mycat catThread = new Mycat();
        catThread.start();
//        catThread.run();
        
        Mydog dogRunnable = new Mydog();
        Thread dogThread = new Thread(dogRunnable);
        dogThread.start();
//        dogThread.run();
	}
}

class Mycat extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++){

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
	
			System.out.println("Cat =" + i + " =>" + Thread.currentThread().getName());
		}
	}
}
    
class Mydog implements Runnable {
   @Override
   public void run(){
       for(int j =1 ; j <= 10 ; j++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
           System.out.println("Dog ="+j+" =>"+ Thread.currentThread().getName());
       }           
   }
}
