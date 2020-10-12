package com.training.session6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool_c3p0 {

	public static void main(String[] args) {
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cpds.setUser("local");
		cpds.setPassword("root");

		// Optional Settings
		cpds.setInitialPoolSize(5); // 初始化時獲取的連線數
		cpds.setMinPoolSize(5); // 最小連線數
		cpds.setMaxPoolSize(20); // 最大連線數
		cpds.setMaxStatements(100); // 最大的Statment數量
		cpds.setAcquireIncrement(5); // 當連線池裡連線數使用完時，再次獲取的新連線數
		/*
			當連線池用完時客戶端呼叫getConnection()後等待獲取新連線的時間
			(單位毫秒,Default: 0)
		 	超時後將拋出SQLException(如設為0則無限期等待)	 	 
		*/
		cpds.setCheckoutTimeout(1000);		
		
		try (Connection connection = cpds.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery("SELECT * FROM COFFEES")) {
			
			while (resultSet.next()) {
				String name = resultSet.getString("COF_NAME");
				int id = resultSet.getInt("SUP_ID");
				float price = resultSet.getFloat("PRICE");
				int sales = resultSet.getInt("SALES");
				int total = resultSet.getInt("TOTAL");
				System.out.print(name + "   " + id + "   " + price);
				System.out.println("   " + sales + "   " + total);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
