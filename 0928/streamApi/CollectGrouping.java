package com.training.session7.lambda.streamApi;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CollectGrouping {

	public static void main(String[] args) {
		
        List<Employee> eList = Employee.createShortList();
        
        // 以部門為群組單位將員工資料分群(Key:部門名稱、Value:部門員工清單)
        Map<String, List<Employee>> gMap = eList.stream()
                .collect(groupingBy(Employee::getDept));
        System.out.println("\n== Employees by Dept ==");
        gMap.forEach((k,v) -> {
            System.out.println("\nDept: " + k); 
            v.forEach(Employee::printSummary);
//            System.out.println(v.stream().mapToDouble(e -> e.getSalary()).average());
        });        
        
        // 以部門為群組單位計算各部門平均薪資
        Map<String, Double> avgSalaryByDept = new HashMap<>();
        avgSalaryByDept = eList.stream()
            .collect( groupingBy( Employee::getDept, averagingDouble(Employee::getSalary) ) );
        System.out.println("\n== Average Salary by Dept ==");
        avgSalaryByDept.forEach( (k,v) -> System.out.println("\nDept: " + k + ", Average Salary: " + v) );         
        
        // 以部門為群組單位找尋各部門薪資最高的員工
        Map<String, Optional<Employee>> maxSalaryByDept = new HashMap<>();
        maxSalaryByDept = eList.stream()
            .collect(groupingBy(Employee::getDept, maxBy(comparing(Employee::getSalary))));        
        System.out.println("\n== Maximum Salary by Dept ==");
        maxSalaryByDept.forEach((k,v) -> System.out.println("\nDept: " + k + ", Maximum Salary: " + v.get().getSalary())); 
	}

}
