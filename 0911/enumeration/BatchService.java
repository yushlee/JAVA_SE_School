package com.training.session6.enumeration;

public class BatchService {
	
	// 修改前
	public void batchJob(String taskName){		
		switch (taskName) {
			case "SendEmail":
				System.out.println("執行  寄信 作業");
				break;
			case "BuildReport":
				System.out.println("執行 建立報表 作業");
				break;
			case "SendFile":
				System.out.println("執行 傳送擋案 作業");
				break;
			default:
				System.out.println("無作業執行錯誤!!!");
		}		
	}
	
	// 修改後傳入列舉
	public void batchTaskJob(Task taskName){	
		switch (taskName) {
			case SendEmail:
				System.out.println("執行  寄信 作業");
				break;
			case BuildReport:
				System.out.println("執行 建立報表 作業");
				break;
			case SendFile:
				System.out.println("執行 傳送擋案 作業");
				break;
			default:
				System.out.println("無作業執行錯誤!!!");
		}
	}
	
}
