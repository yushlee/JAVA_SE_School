package com.training.session3;

import java.sql.*;
import com.training.session1.DBConnectionFactory;
	 
public class CreateCoffeesTable {

	public static void main(String args[]) {

		String  createString = "create table COFFEES " +
							"(COF_NAME varchar(32), " +
							"SUP_ID int, " +
							"PRICE float, " +
							"SALES int, " +
							"TOTAL int)";	

		try (Connection conn = DBConnectionFactory.getLocalDBConnection();
				Statement stmt = conn.createStatement()) {
			
			// Statement 執行 SQL DDL(Data Definition Language)
	   		stmt.executeUpdate(createString);
	
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
	}
}