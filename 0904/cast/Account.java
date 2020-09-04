package com.training.session5.bank.cast;

public class Account {
	
	private double balance; // 餘額	
	
	public Account() { }
	
	public Account(double balance) {
		this.balance = balance;
	}	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
