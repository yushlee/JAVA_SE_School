package com.training.session8.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.training.session8.model.StudentsReport;
import com.training.session8.model.StudentsScore;

public class StudentsScoreService {
	
	/**
	 * Step1:使用File輸入串流將來源檔資料讀出StudentsScoreData.csv <br/>
	 * Step2:計算每一筆學生成績的總分與平均,並存入collection
	 * @param filePath
	 * @return StudentsReport
	 */
	public StudentsReport inputStudentsScoreData(Path filePath) {
		StudentsReport studentsReport = new StudentsReport();
		List<StudentsScore> studentsScoreDatas = null;
		Charset cs = Charset.defaultCharset();
		List<String> originalDatas = null;
		try {
			originalDatas = Files.readAllLines(filePath, cs);
			// 取得來源資料第一行表頭標題
			studentsReport.setReportTitle(originalDatas.get(0));
			// 刪除來源資料第一行表頭標題刪除
			originalDatas.remove(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(originalDatas != null && originalDatas.size() > 0){
			// 原始資料「轉換」處理成StudentsScore物件
			Function<String, StudentsScore> studentMapper = createStudentMapper();
			// StudentsScore平均排序
			Comparator<StudentsScore> studentComparator = (s1, s2) -> {
				return s2.getAverage().compareTo(s1.getAverage());
			};
			
			studentsScoreDatas = originalDatas.stream()
					.map(studentMapper).
					sorted(studentComparator).
					collect(Collectors.toList());
			
			// 產生StudentsScore名次
			int rank = 1;
			for(StudentsScore studentsScoreData : studentsScoreDatas){
				studentsScoreData.setRank(String.valueOf(rank++));
			}
			
			studentsReport.setStudentsScoreDatas(studentsScoreDatas);
		}
		
		return studentsReport;
	}

	private Function<String, StudentsScore> createStudentMapper() {
		Function<String,StudentsScore> studentMapper = s -> {
			StudentsScore student = new StudentsScore();
			String[] data = s.split(",");
			student.setStudentNo(data[0]);
			student.setName(data[1]);
			List<String> scores = new ArrayList<>();
			for(int i = 2 ; i < data.length ; i++){
				scores.add(data[i]);
			}
			student.setScores(scores);
			Integer sum = scores.stream().mapToInt(n -> Integer.parseInt(n)).sum();
			student.setSumScore(sum.toString());
			// 平均分數(計算至小數點第一位四捨五入)
			BigDecimal sumScoreBig = new BigDecimal(String.valueOf(sum.toString())); 
			BigDecimal average = sumScoreBig.divide(new BigDecimal(scores.size()), 1,RoundingMode.HALF_UP);
			student.setAverage(average.toString());
			
			return student;
		};
		
		return studentMapper;
	}	

	
	/**
	 * info:將處理好的collection使用File輸出串流,將資料產出至結果檔StudentsScoreResulet.csv
	 * @param studentsReport
	 */
	public void outputStudentsScoreData(Path reportDir, StudentsReport studentsReport){		
		List<String> reportData = new ArrayList<>();
		// 檔首BOM
		reportData.add(studentsReport.getReportTitle());		
		List<String> reportScores = studentsReport.getStudentsScoreDatas().stream()
				.map(s -> s.toString()).collect(Collectors.toList());
		reportData.addAll(reportScores);
		
		// 資料產出至結果檔
		Charset cs = Charset.defaultCharset();
		try {
			reportData.stream().forEach(s -> System.out.println(s));
			Files.write(reportDir, reportData, cs, 
					StandardOpenOption.CREATE, 
					StandardOpenOption.TRUNCATE_EXISTING,
					StandardOpenOption.WRITE);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
