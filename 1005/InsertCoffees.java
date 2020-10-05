package com.training.session3;

import java.sql.*;
import com.training.session1.DBConnectionFactory;
	 
public class InsertCoffees {

	public static void main(String args[]) {

		try (Connection conn = DBConnectionFactory.getLocalDBConnection()) {
			
			// 設置交易不自動提交
			conn.setAutoCommit(false);
			
			try (Statement stmt = conn.createStatement()) {
				
				stmt.executeUpdate("insert into COFFEES " +
				         "values('Colombian', 00101, 7.99, 0, 0)");
			
				stmt.executeUpdate("insert into COFFEES " +
			         "values('French_Roast', 00049, 8.99, 0, 0)");
				
				stmt.executeUpdate("insert into COFFEES " +
			         "values('Espresso', 00150, 9.99, 0, 0)");
		
				stmt.executeUpdate("insert into COFFEES " +
		             "values('Colombian_Decaf', 00101, 8.99, 0, 0)");
		
				stmt.executeUpdate("insert into COFFEES " +
			         "values('French_Roast_Decaf', 00049, 9.99, 0, 0)");
				
				// 特意將其中一個SQL語句語法錯誤
				 stmt.executeUpdate("insert into COFFEESS " +
				         "values('French_Roast_Decaf', 00049, 9.99, 0, 0)");
				
			} catch(SQLException ex) {
				// 交易取消資料 rollback(必須設置setAutoCommit false)
				conn.rollback();
				ex.printStackTrace();
			}
			
			// Transaction commit(交易提交)
			conn.commit();
			
		} catch(SQLException ex) {			
			System.err.println("SQLException: " + ex.getMessage());
		}
		
	}
}