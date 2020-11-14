package session2.encapsulation;

public class AccountMain {

	public static void main(String[] args) {
//		Account jay = new Account();
//		
//		// 開戶
//		Account tom = new Account(1000);
//		System.out.println(tom.balance);
//		// 存款
//		tom.balance = tom.balance + 200;
//		System.out.println(tom.balance);
//		
//		// 提款(第一次)
//		if(tom.balance >= 500) {
//			tom.balance = tom.balance - 500;
//			System.out.println(tom.balance);
//		}
//		
//		// 提款(第二次)
//		if(tom.balance >= 700) {
//			tom.balance = tom.balance - 700;
//			System.out.println(tom.balance);
//		}
//		
//		// 提款(第三次)
//		if(tom.balance >= 300) {
//			tom.balance = tom.balance - 300;
//			System.out.println(tom.balance);
//		}
		
		Account jay = new Account();
		
		// 開戶
		Account tom = new Account(1000);
		// 存款
		tom.deposit(300);
		
		// 提款
		tom.withdrawal(500);
		
		// 提款
		tom.withdrawal(700);

		// 提款
		tom.withdrawal(200);
		
//		tom.showBalance();
		
	}

}
