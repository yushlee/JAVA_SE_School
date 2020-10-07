package com.training.session3;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.training.session1.DBConnectionFactory;

public class ExecuteBatchInsertData {

	public static void main(String[] args) {
		// Statement executeBatch
		statementBatch();
		// PrepareStatement executeBatch
//		 prepareStatementBatch();
	}

	private static void statementBatch() {
	    // try-with-resource
		try(Connection conn = DBConnectionFactory.getLocalDBConnection()) {
			
			// 設置交易不自動提交
			conn.setAutoCommit(false);
			
			try (Statement stmt = conn.createStatement()) {
				
				// addBatch 批次執行SQL指令
				stmt.addBatch("INSERT INTO BANK_ACCOUNT (name,password,balance,funMoney) values('Tom','123',10000,0)");			
				stmt.addBatch("INSERT INTO BANK_ACCOUNT (name,password,balance,funMoney) values('Casey','123',20000,0)");			
				stmt.addBatch("INSERT INTO BANK_ACCOUNT (name,password,balance,funMoney) values('James','123',15000,0)");
//				stmt.addBatch("INSERT INTO BANK_ACCOUNT (namee,password,balance,funMoney) values('James','123',15000,0)");
				
				// 在執行 executeBatch()時SQL語法若有錯誤的情況下，會拋出 BatchUpdateException例外
				int[] insertCounts = stmt.executeBatch();
				for(int count : insertCounts){ System.out.println(count); }
				
			} catch(BatchUpdateException b) {
				// 交易取消資料 rollback(必須設置setAutoCommit false)
				conn.rollback();
				System.err.println("-----BatchUpdateException-----");
				System.err.println("SQLState:  " + b.getSQLState());
				System.err.println("Message:  " + b.getMessage());
				System.err.println("Vendor:  " + b.getErrorCode());
				System.err.print("Update counts:  ");
				int [] updateCounts = b.getUpdateCounts();
				for (int i = 0; i < updateCounts.length; i++) {
					System.err.print(updateCounts[i] + "   ");
				}
				System.err.println("");
			}
			
			// Transaction commit(交易提交)
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void prepareStatementBatch() {
		String sql = "INSERT INTO BANK_ACCOUNT (name,password,balance,funMoney) values(?, ?, ?, ?)";
		try(Connection conn = DBConnectionFactory.getLocalDBConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);) {
			
			// Set the variables
			stmt.setString(1, "Tom");
			stmt.setString(2, "123");
			stmt.setDouble(3, 10000);
			stmt.setDouble(4, 0);
			// Add it to the batch
			stmt.addBatch();

			stmt.setString(1, "Casey");
			stmt.setString(2, "123");
			stmt.setDouble(3, 20000);
			stmt.setDouble(4, 0);
			stmt.addBatch();

			stmt.setString(1, "James");
			stmt.setString(2, "123");
			stmt.setDouble(3, 15000);
			stmt.setDouble(4, 0);
			stmt.addBatch();

			int[] insertCounts = stmt.executeBatch();
			// PS:Oracle 對於 PreparedStatement 批次更新所回傳的異動筆數沒有支援,但資料仍會被異動!
			for(int count : insertCounts){ System.out.println(count); }

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
