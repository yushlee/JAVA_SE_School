package com.training.session6;

import java.util.Date;

public class EmployeeDaoMain {
	
	public static void main(String[] args){
		
		// 籍由統一的介面 EmployeeDao來操作方法
		// 再透過「多型」的手法就可動態的"抽換"實作「不同的資料儲存方式實作」
		// EmployeeDaoDataBaseImpl、EmployeeDaoFileImpl、EmployeeDaoMemoryImpl
		// 依實際「商業邏輯」上的需求來決定如何新刪修查資料

		Employee emp = new Employee();
		emp.setEname("Tony Stark");
		emp.setJob("CEO");
		emp.setHiredate(new Date());
		emp.setSal(1300);
		emp.setComm(0);
		emp.setDeptno(10);
		
		// 運用多型的特性，依照實際系統的需求動態的抽換實作類別
		// 就可在資料操作行為不變的情況下達到動態儲存資料方式不同的結果
		
		// 儲存至資料庫
		EmployeeDao employeeDao = EmployeeDaoDataBaseImpl.getInstance();	
		operationData(employeeDao, emp);
		
		System.out.println("--------------------------------");
		
		// 儲存至檔案
		employeeDao = EmployeeDaoFileImpl.getInstance();
		operationData(employeeDao, emp);
		
		System.out.println("--------------------------------");
		
		// 儲存至記憶體
		employeeDao = EmployeeDaoMemoryImpl.getInstance();
		operationData(employeeDao, emp);
	}
	
	public static void operationData(EmployeeDao employeeDao, Employee emp){
		// 統一由介面 Interface EmployeeDao來操作方法,撰寫者無須關切資料最後將如何被儲存.		
		// 儲存資料
		int empNo = employeeDao.add(emp);
		System.out.println("新增 Employee empNo:" + empNo);
		// 更新資料
		emp.setEmpno(empNo);
		emp.setSal(2000);
		int updateCount = employeeDao.update(emp);
		System.out.println("更新 Employee 異動的資料筆數:" + updateCount);
		// 查詢資料(單筆)
		emp = employeeDao.findById(emp.getEmpno()); 
		System.out.println(emp);
		// 刪除資料
		int delCount = employeeDao.delete(emp.getEmpno());
		System.out.println("刪除 Employee 異動的資料筆數:" + delCount);
		// 查詢資料(全部)
		Employee[] emps = employeeDao.getAllEmployees();
		System.out.println("Employee size：" + emps.length);
		for(Employee employee : emps){
			System.out.println(employee);
		}
	}
	
}
