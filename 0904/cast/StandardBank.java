package com.training.session5.bank.cast;

public class StandardBank {
	// Account用戶
	protected Account account;
	
	public StandardBank() {}
	
	public StandardBank(Account account){
        this.account = account;
    }
	
    // 存款:deposit
    public void deposit(int amt){
        if(amt>=0) {
        	// 取得餘額
        	double balance = account.getBalance();
            balance += amt;
            // 更新餘額
            account.setBalance(balance);
        } else {
        	System.out.println("不能存0元");
        }
        getBalance();
    }
    
    // 提款:withdraw
    public void withdraw(double amt){
    	// 取得餘額
    	double balance = account.getBalance();
        if(amt>=0 && balance>=amt) {
            balance -= amt;
            // 更新餘額
            account.setBalance(balance);
        } else {
        	System.out.println("存款餘額不足,您的存款餘額為:" + balance);
        }
        getBalance();
    }
    
    // 查詢目前餘額:getBalance
    protected void getBalance() {
    	double balance = account.getBalance();
    	System.out.println("您的存款餘額為:"+ balance);		
	}
    
    /**
     * info:依照所貸款的金額及貸款年數回傳房貸利率金額試算
     * @param loanAmount 貸款金額
     * @param loanYear 貸款年數; 單位:(5,10,15,20)
     * @return float(年息金額)
     */
    protected float housingLoan(long loanAmount, int loanYear) {
    	// 由父類別來統一規範方法的Input、Output
    	// 各子類別再自行決定是否要 Override(覆寫)
    	System.out.println("您的房貸金額:"+loanAmount+" 貸款年數:"+loanYear);
    	float interestRate = 0;
    	switch (loanYear) {
			case 20:
				interestRate = 0.03f;
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
