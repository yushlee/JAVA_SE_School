package com.training.session5.bank.cast;

public class BankMainDependence {

	public static void main(String[] args) {
		/*
		Account kevinAccount = new Account(5000000);
		// 直接依賴於實作(高耦合)
		FetBank fetBank = new FetBank(kevinAccount);
		// 導致無法抽換其實作類別
		fetBank = new TaiwanBank(kevinAccount);
		*/

		Account kevinAccount = new Account(5000000);
		// 依賴於某個抽象(Interface)而不是直接依賴於實作元件
		// 可以隨時抽換實作類別，達到動態切換行為結果的彈性!
		StandardBank fetBank = new FetBank(kevinAccount);
		// 遠東的房貸計算結果
		System.out.println(fetBank.housingLoan(1000000, 20));
		// 台灣的房貸計算結果
		fetBank = new TaiwanBank(kevinAccount);
		System.out.println(fetBank.housingLoan(1000000, 20));		
	}
}
