
public class Account {
	// 帳戶餘額
	private int balance;
	
	public Account() {}
	
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
		if(balance >= money) {
			balance = balance - money;
		}
		
		showBalance();
		
//		Account tom = new Account();
//		tom.showBalance();
	}
	
	public void showBalance(){
		System.out.println(balance);
	}
}
