package session2.encapsulation;

public class Account {
	
	private int balance;
	 
	public Account(){
		
	}
	
	public Account(int money){
		balance = money;
	}
	
	// 存款
	public void deposit(int money){
		balance = balance + money;
		showBalance();		
	}
	
	// 提款
	public void withdrawal(int money){
		// 如果
		if(balance >= money){
			balance = balance - money;
		} else {
			System.out.println("哈哈~存款餘額不足!");
		}
		
		showBalance();		
	}
	
	// 查詢餘額
	public void showBalance(){
		System.out.println("先生/女士的帳戶餘額為:" + balance);
	}
}
