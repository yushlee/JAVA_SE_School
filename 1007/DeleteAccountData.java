package com.training.session3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.training.session1.DBConnectionFactory;

public class DeleteAccountData {
	public static void main(String[] args) {

		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getLocalDBConnection()){
			// 設置交易不自動提交
			conn.setAutoCommit(false);
			// DELETE SQL
			String deleteSql = "DELETE FROM BANK_ACCOUNT WHERE name = ?";			
			// Step2:Create prepareStatement For SQL			
			try (PreparedStatement stmt = conn.prepareStatement(deleteSql)){
				// Step3:將"資料欄位編號"、"資料值"作為引數傳入
				stmt.setString(1, "James");
				// Step4:Execute SQL
				int count = stmt.executeUpdate();
				System.out.println("刪除異動的資料筆數:" + count);
				// Step5:交易提交
				conn.commit();
			} catch (SQLException e) {
				// 若發生錯誤則資料 rollback(回滾)
				conn.rollback();
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
