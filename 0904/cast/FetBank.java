package com.training.session5.bank.cast;

import com.training.session6.bank.ClassType.StandardBankService;

public class FetBank extends StandardBank {
	
	public FetBank(Account account) {
		super(account);
	}
	
	@Override
    protected float housingLoan(long loanAmount, int loanYear) {
    	System.out.println("您的房貸金額:"+loanAmount+" 貸款年數:"+loanYear);
    	float interestRate = 0;
    	switch (loanYear) {
			case 20:				
				interestRate = 0.03f;
				double balance = super.account.getBalance();
				// 若於本行存款超過五百萬,即享有與10年房貸一樣的利率優惠!
				if(balance >= 5000000) {
					interestRate = 0.02f;
				}
				break;
			case 15:
				interestRate = 0.025f;
				break;
			case 10:
				interestRate = 0.02f;
				break;
			case 5:
				interestRate = 0.015f;
				break;
		}
    	
    	return loanAmount * interestRate;
    }
}
