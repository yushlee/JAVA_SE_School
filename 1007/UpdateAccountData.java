package com.training.session3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.training.session1.DBConnectionFactory;

public class UpdateAccountData {
	public static void main(String[] args) {
		// 準備要更新至資料庫的物件資料
		Account account = new Account();
		account.setName("James");
		account.setPassword("123456");
		account.setBalance(5000);
		account.setFunMoney(6000);

		updateAccountData(account);
		
	}

	private static void updateAccountData(Account account) {
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getLocalDBConnection()){
			// 設置交易不自動提交
			conn.setAutoCommit(false);			
			// Update SQL
//			String updateSql = "UPDATE BANK_ACCOUNT SET password = ?, balance = ?, funMoney = ? WHERE name = ?";
			String updateSql = "UPDATE BANK_ACCOUNT SET password = ? WHERE balance > ?";
			// Step2:Create prepareStatement For SQL
			try (PreparedStatement stmt = conn.prepareStatement(updateSql)){
				// Step3:將"資料欄位編號"、"資料值"作為引數傳入
//				stmt.setString(1, account.getPassword());
//				stmt.setDouble(2, account.getBalance());
//				stmt.setDouble(3, account.getFunMoney());			
//				stmt.setString(4, account.getName());
				stmt.setString(1, account.getPassword());
				stmt.setDouble(2, account.getBalance());
				// Step4:Execute SQL			
				int count = stmt.executeUpdate();
				System.out.println("更新異動的資料筆數:" + count);
				// Step5:交易提交
				conn.commit();	
			} catch (SQLException e) {
				// 發生 Exception 交易資料 roll back
				conn.rollback();
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
