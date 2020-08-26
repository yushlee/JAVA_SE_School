package com.training.session4.drink;

public class DrinkMachineMain {

	public static void main(String[] args) {
//		coke $35 3
//		fonda $25 20
//		sprite $30 20
		
		DrinkMachine drinkMachine = new DrinkMachine();
		DrinkMachineReturn drinkRtn = drinkMachine.buyDrink("coke", 40);
		System.out.println(drinkRtn);
		drinkRtn = drinkMachine.buyDrink("coke", 100);
		System.out.println(drinkRtn);
		drinkRtn = drinkMachine.buyDrink("coke", 50);
		System.out.println(drinkRtn);
		drinkRtn = drinkMachine.buyDrink("coke", 50);
		System.out.println(drinkRtn);
		drinkRtn = drinkMachine.buyDrink("fonda", 50);
		System.out.println(drinkRtn);
		drinkRtn = drinkMachine.buyDrink("fonda", 75);
		System.out.println(drinkRtn);
		drinkRtn = drinkMachine.buyDrink("sprite", 30);
		System.out.println(drinkRtn);
		drinkRtn = drinkMachine.buyDrink("sprite", 10);
		System.out.println(drinkRtn);
		
		// 列印分隔線
		System.out.println("========================================");
		// 販賣機報表(可列出每項飲品:已售出數量、現有庫存量、已售出金額 ; 總營業金額)
		drinkMachine.showDrikReport();
	}

}
