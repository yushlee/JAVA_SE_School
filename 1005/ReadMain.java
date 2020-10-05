package com.training.session3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.training.session1.DBConnectionFactory;

public class ReadMain {
	public static void main(String[] args) {
		// 請先執行 CreateAccountTable.java 至 Local DB
		String querySQL = "SELECT * FROM BANK_ACCOUNT";

		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getLocalDBConnection();
				// Step2:Create Statement
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(querySQL)) {
			// Step3:Process Result
			while (rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				double balance = rs.getDouble("balance");
				double funMoney = rs.getDouble("funMoney");
				Account account = new Account();
				account.setName(name);
				account.setPassword(password);
				account.setBalance(balance);
				account.setFunMoney(funMoney);
				System.out.println(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
