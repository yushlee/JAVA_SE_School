package com.training.session7.Synchronized;

public class SynchronizedExp {
	
	public static void main(String[] args) {	
		
		Resource resource = new Resource();
		// T1、T2 傳入同一個Resource物件,模擬資料共用同步存取問題!
		new Thread(new T1(resource)).start(); // 10 + 20 = 30		
		new Thread(new T2(resource)).start(); // 30 + 40 = 70
		
	}
	
}

class Resource {
	
	int a, b;
	
	 // 於方法上加修飾子 synchronized(同步)
	public synchronized void add(int v1, int v2, Object lockKey) {
		// 於需同步化的地方加入 synchronized block(同步化區塊)
		// 1.綁定自身 Resource 物件
		synchronized (this){
		// 2.須綁定同一個參照來源物件
//		synchronized (lockKey){
			a = v1;

			try {
				Thread.sleep(800);
			} catch (InterruptedException ex) {
			}

			b = v2;
			
			System.out.println(this);
			System.out.println("a:" + a + " + b:" + b + " = " + (a + b));
		 }
	}
	
	@Override
	public String toString() {
		return "Resource synchronized";
	}	
}

class T {
//	public Object lockKey = new Object();
	public static Object lockKey = new Object();
}

class T1 extends T implements Runnable{
	
	Resource r;

	T1(Resource r) {
		this.r = r;
	}

	public void run() {
		r.add(10, 20, lockKey);
	}
	
}

class T2 extends T implements Runnable{
	
	Resource r;

	T2(Resource r) {
		this.r = r;
	}

	public void run() {
		r.add(30, 40, lockKey);
	}
	
}


