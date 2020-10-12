package com.training.session6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPoolTestMultiThread {

	public static void main(String[] args) throws InterruptedException {
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cpds.setUser("local");
		cpds.setPassword("root");

		// Optional Settings
		cpds.setInitialPoolSize(1);    // 初始化時獲取的連線數
		cpds.setMinPoolSize(1);        // 最小連線數
		cpds.setMaxPoolSize(1);        // 最大連線數
		cpds.setMaxStatements(100);    // 最大的Statment數量
		cpds.setAcquireIncrement(1);   // 當連線池裡連線數使用完時，再次獲取的新連線數
		cpds.setCheckoutTimeout(0); // 當連線池用完時客戶端呼叫getConnection()後等待獲取新連線的時間	
		
		DataBaseUser user1 = new DataBaseUser("USER_1", cpds);
		DataBaseUser user2 = new DataBaseUser("USER_2", cpds);
		DataBaseUser user3 = new DataBaseUser("USER_3", cpds);
		
		Thread thread1 = new Thread(user1);
		Thread thread2 = new Thread(user2);
		Thread thread3 = new Thread(user3);
		
		// 執行緒開始
		thread1.start();
		thread2.start();
		// 3號使用者特意晚了1秒才取資料庫連線
		Thread.sleep(1000);
		thread3.start();
	}

}

class DataBaseUser implements Runnable {	
	
	private String userName;
	
	private ComboPooledDataSource cpds;	
	
	public DataBaseUser(String userName, ComboPooledDataSource cpds) {
		this.userName = userName;
		this.cpds = cpds;
	}

	@Override
    public void run() {		
		try (Connection connection = cpds.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery("SELECT * FROM COFFEES")) {
			
			System.out.println("Get Connection executeQuery Start userName：" + userName);
			
			while (resultSet.next()) {
				System.out.println(userName + " 查詢第  " + resultSet.getRow() + " 筆資料");
				// 特意等待佔有資料庫連線
				Thread.sleep(1000);
			}
			
			System.out.println("Get Connection executeQuery End userName：" + userName);
			
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
    }

}