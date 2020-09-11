package com.training.session6.enumeration;

public enum Task {
	
	SendEmail(1, "寄信"),
	BuildReport(2, "建立報表"),
	SendFile(3, "傳送檔案");
	
	private int taskNumber;
	
	private String taskName;
	
	// 列舉建構式的修飾子必須是private私有的(僅供內部資料實體化使用)
	// private可省略不寫
	private Task(int taskNumber, String taskName){
		this.taskNumber = taskNumber;
		this.taskName = taskName;
	}

	public int getTaskNumber() {
		return taskNumber;
	}

	public String getTaskName() {
		return taskName;
	}
	
	
	
}
