
public class Account {
	// 帳戶餘額
	private int balance;
	
	public Account() {}
	
	public Account(int money){
		balance = money;
	}
	
	// 存款
	public void deposit(int money){
		if(money > 0){
			balance = balance + money;
		}
		
		showBalance();
	}
	
	// 提款 
	public void withdrawal(int money){
		boolean isPass = balance >= money;
		if(isPass) {
			balance = balance - money;
		} else {
			System.out.println("您的存款餘額不足...哈哈");
		}
		
		showBalance();
		
//		Account tom = new Account();
//		tom.showBalance();
	}
	
	public void showBalance(){
		System.out.println(balance);
	}
}
