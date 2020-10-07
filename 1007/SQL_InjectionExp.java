package com.training.session3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.training.session1.DBConnectionFactory;

public class SQL_InjectionExp {

	public static void main(String[] args) {
		
		// 正常參數值
		String firstName = "'Steven'";
		String phoneNumber = "'515.123.4567'";
		
		// 惡意參數值(SQL injection 注入攻擊)
//		 String firstName = "1 OR 1 = 1";
//		 String phoneNumber = "1 OR 1 = 1";
		
		statementQuery(firstName, phoneNumber);

//		PreparedStatement 自動會將整個參數值用「引號」包起來
//		String firstName = "Steven";
//		String phoneNumber = "515.123.4567";		
		
//		 preparedStatementQuery(firstName, phoneNumber);
	}
	
	public static void statementQuery(String firstName, String phoneNumber) {
		String querySQL = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME = "+ firstName +" AND PHONE_NUMBER = " + phoneNumber;
		System.out.println(querySQL);
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getHrDBConnection();
				// Step2:Create Statement
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(querySQL)) {
			// Step3:Process Result
			while (rs.next()) {	
				System.out.println("FIRST_NAME:" + rs.getString("FIRST_NAME"));
				System.out.println("SALARY:" + rs.getInt("SALARY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void preparedStatementQuery(String firstName, String phoneNumber) {
		String querySQL = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME = ? AND PHONE_NUMBER = ?";
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getHrDBConnection();
			 // Step2:Create PreparedStatement For SQL
			 PreparedStatement stmt = conn.prepareStatement(querySQL)){
			// 透過PreparedStatement setXXX方法，會將整個參數值用「引號」包起來，從而避免了參數值被做為條件的一部分
			stmt.setString(1, firstName);
			stmt.setString(2, phoneNumber);
			try (ResultSet rs = stmt.executeQuery()){
				// Step3:Process Result
				while(rs.next()) {
					System.out.println("FIRST_NAME:" + rs.getString("FIRST_NAME"));
					System.out.println("SALARY:" + rs.getInt("SALARY"));			
				}	
			} catch (SQLException e) {
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
