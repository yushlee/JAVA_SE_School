package com.training.session2;

public class CustomerMain {

	public static void main(String[] args) {
//		String cusName = "馬小九";
		Customer customer = new Customer();
//		String name = customer.maskName(cusName);
//		System.out.println(name);
		
		System.out.println(customer.maskName("趙雲"));
		System.out.println(customer.maskName("趙子龍"));
		System.out.println(customer.maskName("司馬中承"));
		System.out.println(customer.maskName("常山趙子龍"));

	}

}
