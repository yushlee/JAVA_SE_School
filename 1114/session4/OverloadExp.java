package com.training.session4;

public class OverloadExp {
	public static void main(String[] args) {
        int v =  10;
        Order order = new Order();
        order.test(v);
    }
}

class Order{
	// 1.相同型別	
    public void test(int v)  {System.out.println('A');}
    // 2.放大
    public void test(long v) {System.out.println('B');}
    // 3.AutoBoxing
    public void test(Integer v)  {System.out.println('C');}
    // 4.易變參數
    public void test(int... v) {System.out.println('D');}
    
    public void test(Long v)  {System.out.println('E');}
}
