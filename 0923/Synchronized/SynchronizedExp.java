package com.training.session7.Synchronized;

public class SynchronizedExp {

	public static void main(String[] args) {
		
		Resource r = new Resource();
		T1 t1 = new T1(r); // 30(10, 20)
		T2 t2 = new T2(r); // 70(30, 40)
		

		t1.start();
		t2.start();

	}

}

class Resource {
	
	static Object blockKey = new Object();
	
	// Member scope
	int a, b;
	
//	public synchronized void add(int v1, int v2) {
	public void add(int v1, int v2) {
		// Local scope
//		int a, b;
		
		synchronized(blockKey){
			System.out.println(this);
			a = v1;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			b = v2;
			System.out.println(a + b);
		}
		
	}

	@Override
	public String toString() {
		return "Resource";
	}	
	
}

class T1 extends Thread {
	Resource r;

	T1(Resource r) {
		this.r = r;
	}

	public void run() {
		r.add(10, 20);
	}
	
	
}

class T2 extends Thread {
	Resource r;

	T2(Resource r) {
		this.r = r;
	}

	public void run() {
		r.add(30, 40);
	}
}