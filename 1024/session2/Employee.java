package session2;
// Class 類別
public class Employee {
	
	// Filed 欄位
	public int empNumber;
	public String name;
	public String title;
	
	
	// 預設建構式
	public Employee(  ) { 
		title = "新進人員";
	}
	
	// 自訂義建構式
	public Employee(int number, String empTitle) {
		empNumber = number;
		title = empTitle;		
	}
	
	// Method 方法 V + N
	public int calculateSalary (int salary, int day) {
		// Process		
		
		// 遲到天數(1天扣1百)
		int lessMoney = day * 100;
		System.out.println(lessMoney);
		int totalSalary = salary + 2400 - lessMoney;
		
		return totalSalary;		
	}
	
	public void showEmployee(){
		System.out.println(empNumber);
		System.out.println(name);
		System.out.println(title);
//		System.out.println(lessMoney);
	}
	
}