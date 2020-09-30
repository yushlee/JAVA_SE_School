package com.training.session3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.training.session1.DBConnectionFactory;

public class CreateAccountTable {
	public static void main(String[] args) {
		// DDL(Data Definition Language)
		String createTable = "CREATE TABLE BANK_ACCOUNT (" +
								"NAME VARCHAR2(20) NOT NULL PRIMARY KEY " +
								", PASSWORD VARCHAR2(40) NOT NULL " +
								", BALANCE NUMBER NOT NULL " +
								", FUNMONEY NUMBER NOT NULL)";
		
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getLocalDBConnection();
			 // Step2:Create Statement
			 Statement stmt = conn.createStatement()){
			 stmt.executeUpdate(createTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
