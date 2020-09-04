package com.training.session5.bank.cast;

public class TaiwanBank extends StandardBank {
	
	public TaiwanBank(Account account) {
		super(account);
	}
	
	@Override
    protected float housingLoan(long loanAmount, int loanYear) {
    	System.out.println("您的房貸金額:"+loanAmount+" 貸款年數:"+loanYear);
    	float interestRate = 0;
    	switch (loanYear) {
			case 20:
				interestRate = 0.025f;
				break;
			case 15:
				interestRate = 0.02f;
				break;
			case 10:
				interestRate = 0.015f;
				break;
			case 5:
				interestRate = 0.01f;
				break;
		}
    	
    	return loanAmount * interestRate;
    }
}
