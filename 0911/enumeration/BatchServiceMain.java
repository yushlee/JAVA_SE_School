package com.training.session6.enumeration;

public class BatchServiceMain {

	public static void main(String[] args) {
		BatchService batchService = new BatchService();
//		batchService.batchJob("BuildReport");
		batchService.batchJob("sendFile");
		
		batchService.batchTaskJob(Task.SendEmail);
		
	}

}
