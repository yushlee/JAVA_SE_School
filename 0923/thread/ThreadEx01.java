package com.training.session7.thread;

public class ThreadEx01 {

	public static void main(String[] args) {
        System.out.println("Start =>" + Thread.currentThread().getName());
        
        for(int i=0;i<10;i++){
            System.out.println("i =>" +  i + "=>" + Thread.currentThread().getName());
        }

        System.out.println("End" + "=>" + Thread.currentThread().getName());
	}

}
