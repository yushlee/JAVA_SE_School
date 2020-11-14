package com.training.session4;

public class Calculator {
	// Overload 多載
	// 在同一個 class有數個
	// 1.同名
	// 2.參數不同(1.數量、2.型別)
	// 3.目的為提供相同功能但允許輸入不同參數
    public void add(int a,double b){
        System.out.println(a + b);
    }    
    
    public void add(int a,int b){
        System.out.println(a + b);
    }
    
    public void add(int a,int b,int c){
        System.out.println(a + b + c);
    }
    
    public void add(int a,int b,int c ,int d){
        System.out.println(a + b + c + d);
    }
    
    public void add(int a,int b,int c ,int d , int e){
        System.out.println(a + b + c + d + e);
    }    
    
    
//  VariableArguments易變參數
//  1.相同型別,數量不固定的方法參數
//  2.本質上為陣列
//	3.必須在參數列上最後一個位置    
    public void add(int... values){
        int sum = 0;
        for(int index = 0 ; index < values.length ; index++) {
        	sum += values[index];
        }
        System.out.println(sum);
    }
}
