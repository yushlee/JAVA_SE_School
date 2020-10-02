package com.training.session8.job;

import java.nio.file.Path;
import java.nio.file.Paths;
import com.training.session8.model.StudentsReport;
import com.training.session8.service.StudentsScoreService;

public class StudentsScoreJob {
	public static void main(String[] args) {

		Path filePath = Paths.get("dir/session8/StudentsScoreData.csv");
		Path reportDir = Paths.get("dir/session8/StudentsScoreResulet.csv");
		StudentsScoreService service = new StudentsScoreService();
		// Step1:使用File輸入串流將來源檔資料讀出	
		// Step2:計算每一筆學生成績的總分與平均,並存入collection
		StudentsReport studentsReport = service.inputStudentsScoreData(filePath);		
		if(studentsReport.getStudentsScoreDatas() != null && 
				studentsReport.getStudentsScoreDatas().size() > 0){
			// Step3:將處理好的collection使用File輸出串流,將資料產出至結果檔StudentsScoreResulet.csv
			service.outputStudentsScoreData(reportDir, studentsReport);
		}
		
	}
}
