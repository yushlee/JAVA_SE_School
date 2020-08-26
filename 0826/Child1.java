package com.training.session4;

// java 不允許多重繼承
// public class Child1 extends Father ,郭苔銘{
public class Child1 extends Father {
	
	public String 兒子的欄位;
	
	public Child1(){
		// 1.呼叫父類的(預設)建構式
		// 2.this( )、super( ) 只能擇一引用
//		super();
		this("TOYOTA");
		System.out.println("兒子出生了!");
		// 3.子類別可透過 super 引用父類別的"欄位"和"方法"
		System.out.println(this.兒子的欄位);
		System.out.println(super.父親的欄位);
		super.父親的方法();
	}
	
	public Child1(String car){
		// 子類別建構式會自動(隱含)呼叫父類別預設建構式 super( )
		super();
		兒子的欄位 = car;
	}
	
	
	
	public void 兒子的方法(){
		
	}
}
