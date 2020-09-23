package com.training.session7.runnable;

public class RunnableEx04 {
	public static void main(String[] args) {
		// "extends Thread" VS "implements Runnable"
		// 1.在實務上選擇實作Runnable會獲得較好的程式彈性,因為如果選擇繼承Thread此做法將會損失唯一可繼承的機會了!
        // 2."implements Runnable" -> Multiple threads share the same object.
        //	 "extends Thread" -> Creating new instance for every thread access.
		System.out.println("-------------------- extends Thread --------------------");
		StrangerA strangerA = new StrangerA();
		strangerA.start();
		StrangerB strangerB = new StrangerB();
		strangerB.start();
		StrangerC strangerC = new StrangerC();
		strangerC.start();
		
		System.out.println("-------------------- implements Runnable --------------------");
		Family family = new Family();
		family.shareResources(new Father());
		family.shareResources(new Mother());
		family.shareResources(new Children());
	}
}

class StrangerA extends Thread {
    @Override
    public void run(){
    	System.out.println("陌生人A");
    }	
}

class StrangerB extends Thread {
    @Override
    public void run(){
    	System.out.println("陌生人B");
    }	
}

class StrangerC extends Thread {
    @Override
    public void run(){
    	System.out.println("陌生人C");
    }	
}

class Family {
	public Family() {
		// Family Resources
		System.out.println("愛、房子、車子、食物、...");
	}
	
	public void shareResources(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
	}
}

class Father extends Family implements Runnable {
	@Override
	public void run() {
		System.out.println("我是爸爸");
	}	
}

class Mother extends Family implements Runnable {
	@Override
	public void run() {
		System.out.println("我是媽媽");
	}
}

class Children extends Family implements Runnable {
	@Override
	public void run() {
		System.out.println("我是小孩");
	}
}
