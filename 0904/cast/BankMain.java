package com.training.session5.bank.cast;

public class BankMain {
	public static void main(String[] args) {		

		System.out.println("=======================StandardBank=======================");
		Account tomAccount = new Account();
		// 1.由父類別(StandardBank)統一操作方法
		// 物件可操作的方法取決於所宣告的「型別」也就是類別
		// 執行的行為結果取決於所初始化的「物件實例類型」
//		StandardBank bank = new StandardBank(tomAccount);
		housingLoan(new StandardBank(tomAccount));
		
		System.out.println("=======================TaiwanBank=======================");
		Account caseyAccount = new Account();
		// 2.再籍由抽換實體類別的方式 (StandardBank、TaiwanBank、FetBank)
//		bank = new TaiwanBank(caseyAccount);
		housingLoan(new TaiwanBank(caseyAccount));
		
		System.out.println("=======================FetBank=======================");
		Account kevinAccount = new Account(5000000);
//		bank = new FetBank(kevinAccount);
		housingLoan(new FetBank(kevinAccount));
		
		/*
		  Java多型的設計手法可提高程式的「內聚性」、「低耦合」等特性
		    「高內聚性」high cohesion：類別具備完整的功能，程式直接依賴實作元件的程度低；程式碼因集中而好管理
		    「低耦合度」loosely coupled：依賴於某個抽象(Interface)而不是直接依賴於實作元件，可以隨時抽換實作類別，達到動態切換行為結果的彈性!
		*/
	}

	private static void housingLoan(StandardBank standardBank) {
		// 3.就可以在不變動操作的方法狀況下，達到動態變換行為執行結果的呈現!
		// 沒有Override:延用父類別方法
		standardBank.deposit(1000);
		standardBank.withdraw(800);
		// 利用「繼承」與「多型」的特性，搭配方法「Override(覆寫)」，以獲得呈現行為動態切換的彈性
		// 有Override:使用子類別方法
		System.out.println("年息:" + standardBank.housingLoan(10000000, 20));
		System.out.println("年息:" + standardBank.housingLoan(10000000, 5));
	}
	
	
}
