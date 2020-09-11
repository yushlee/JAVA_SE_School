package com.training.session6.enumeration;


public class BatchServiceMain {

	public static void main(String[] args) {
		BatchService batchService = new BatchService();
//		batchService.batchJob("BuildReport");
//		batchService.batchJob("sendFile");
		
//		batchService.batchTaskJob(Task.SendEmail);
		
		
		Task[] tasks = Task.values();
		for(Task task : tasks){
			System.out.println(task.toString());
			System.out.println(task.getTaskNumber());
			System.out.println(task.getTaskName());
			System.out.println("---------------------------");
		}
		
		System.out.println(Task.BuildReport.getTaskName());
		
		// Cannot instantiate the type Task
//		Task xxx = new Task(1, "");
		
	}

}
