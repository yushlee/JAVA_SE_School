package com.training.session8.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsScore {
	
	// 座號
	private String studentNo;
	// 姓名
	private String name;
	// 國文、英文、數學...各科成績分數
	private List<String> scores;	
	// 總分
	private String sumScore;
	// 平均
	private String average;
	// 名次
	private String rank;	

	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getScores() {
		return scores;
	}
	public void setScores(List<String> scores) {
		this.scores = scores;
	}
	public String getSumScore() {
		return sumScore;
	}
	public void setSumScore(String sumScore) {
		this.sumScore = sumScore;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {		
		List<String> csv = new ArrayList<>();
		csv.add(studentNo);
		csv.add(name);
		csv.addAll(scores);
		csv.add(sumScore);
		csv.add(average);
		csv.add(rank);
		
		return csv.stream().collect(Collectors.joining(","));
	}
}
 
