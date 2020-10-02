package com.training.session8.model;

import java.util.List;

public class StudentsReport {
	
	private String reportTitle;
	
	private List<StudentsScore> studentsScoreDatas;

	public String getReportTitle() {
		return "\uFEFF" + reportTitle + ",總分,平均,名次";
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public List<StudentsScore> getStudentsScoreDatas() {
		return studentsScoreDatas;
	}

	public void setStudentsScoreDatas(List<StudentsScore> studentsScoreDatas) {
		this.studentsScoreDatas = studentsScoreDatas;
	}
	
}
