package com.training.session3;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.training.session1.DBConnectionFactory;

public class JoinQuery {
	public static void main(String[] args) {
		// GEOGRAPHY_STORE_DDL.sql、GEOGRAPHY_STORE_DATA.sql
		// RIGHT、LEFT、FULL JOIN
		String querySQL = "SELECT G.GEOGRAPHY_ID, G.REGION_NAME, " + 
						   		"S.STORE_ID, S.STORE_NAME, S.SALES "+
						   "FROM GEOGRAPHY G FULL JOIN STORE_INFORMATION S "+
						   "ON G.GEOGRAPHY_ID = S.GEOGRAPHY_ID";

		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getLocalDBConnection();
				// Step2:Create Statement
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(querySQL)) {
			
			System.out.println("GEOGRAPHY_ID \t REGION_NAME \t STORE_ID \t STORE_NAME \t SALES");
			// Step3:Process Result
			while (rs.next()) {
				BigDecimal geographyID = rs.getBigDecimal("GEOGRAPHY_ID");
				String regionName = rs.getString("REGION_NAME");
				BigDecimal storeID = rs.getBigDecimal("STORE_ID");
				String storeName = rs.getString("STORE_NAME");
				BigDecimal sales = rs.getBigDecimal("SALES");
				System.out.printf("%s \t %s \t %s \t %s \t %s \n", 
						geographyID, regionName, storeID, storeName, sales);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
