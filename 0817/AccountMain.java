
public class AccountMain {

	public static void main(String[] args) {
		BadAccount tomAccount = new BadAccount(1000);
		System.out.println(tomAccount.balance);
		// 存款deposit
		tomAccount.balance = tomAccount.balance + 200;
		System.out.println(tomAccount.balance);
		
		// if(判斷式)
		if(tomAccount.balance >= 300) {
			tomAccount.balance = tomAccount.balance - 300;
		}
		System.out.println(tomAccount.balance);
		
		if(tomAccount.balance >= 400) {
			tomAccount.balance = tomAccount.balance - 400;
		}
		System.out.println(tomAccount.balance);
		
		if(tomAccount.balance >= 600) {
			tomAccount.balance = tomAccount.balance - 600;
		}
		System.out.println(tomAccount.balance);
		
		System.out.println("========================================");
		
		Account wendyAccount = new Account(1000);
		wendyAccount.withdrawal(300);
//		wendyAccount.showBalance();
		wendyAccount.withdrawal(400);
		wendyAccount.withdrawal(600);
		wendyAccount.deposit(100);
		
	}

}
