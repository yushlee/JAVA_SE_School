package session2.homework;

public class CustomerMain {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
//		1.若顧客姓名為兩個字則隱碼第二個字		
		System.out.println(customer.maskCustomer("陳雷")); // 陳X
		
//		2.若為三個字則隱碼第二個字
		System.out.println(customer.maskCustomer("趙子龍")); // 趙X龍 
//		3.若為四個字則隱碼第二、第三個字
		System.out.println(customer.maskCustomer("歐陽妮妮")); // 歐XX妮
//		4.若為四個字以上則一律隱碼第二、第三個字
		System.out.println(customer.maskCustomer("常山趙子龍")); // 常XX子龍
	}

}
