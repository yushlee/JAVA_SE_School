package com.training.session3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.session1.DBConnectionFactory;

public class ReadDataParameterize {
	public static void main(String[] args) {
		
		String querySQL = "SELECT * FROM BANK_ACCOUNT WHERE NAME = ? AND BALANCE > ?";
		
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getLocalDBConnection();
			 // Step2:Create PreparedStatement For SQL
			 PreparedStatement stmt = conn.prepareStatement(querySQL)){
			// 設置查詢的欄位值
			stmt.setString(1, "James");
			stmt.setDouble(2, 100);
			try (ResultSet rs = stmt.executeQuery()){
				// Step3:Process Result
				while(rs.next()) {
					String name = rs.getString("name");
					String password = rs.getString("password");
					double balance = rs.getDouble("balance");
					double funMoney = rs.getDouble("funMoney");
					Account account = new Account();
					account.setName(name);
					account.setPassword(password);
					account.setBalance(balance);
					account.setFunMoney(funMoney);
					System.out.println(account.toString());				
				}	
			} catch (SQLException e) {
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
