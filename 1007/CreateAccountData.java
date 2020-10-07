package com.training.session3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.training.session1.DBConnectionFactory;

public class CreateAccountData {
	public static void main(String[] args) {
		
		// 準備要新增至資料庫的物件資料
		Account account = new Account();
		account.setName("Stave");
		account.setPassword("123");
		account.setBalance(10000);
		account.setFunMoney(1.2345);
		
		// 一般會將資料整合成一個「資料物件」再傳入,可避免一次傳入多個參數而導致傳入順序錯誤
		careateAccount(account);		
	}

	private static void careateAccount(Account account) {
		// Insert SQL			
		String insertSQL = "INSERT INTO BANK_ACCOUNT (NAME, PASSWORD, BALANCE, FUNMONEY) values(?,?,?,?)";
		
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getLocalDBConnection();
				// Step2:Create prepareStatement For SQL
				PreparedStatement stmt = conn.prepareStatement(insertSQL)){
			
			// Step3:將"資料欄位編號"、"資料值"作為引數傳入
			int count = 1;
			stmt.setString(count++, account.getName());
			stmt.setString(count++, account.getPassword());
			stmt.setDouble(count++, account.getBalance());
			stmt.setDouble(count++, account.getFunMoney());
			
			// Step4:Execute SQL
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
