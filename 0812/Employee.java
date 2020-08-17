

public class Employee {
	
	public String empName;
	
	public String title;
	
	public int empNumber;
	
	public int calculateSalary (int basicSalary) {
		int monthlySalary = basicSalary + 2400;
	
		return monthlySalary;
	}
	
	public void showEmployee (){
		System.out.println(empName);
		System.out.println(title);
		System.out.println(empNumber);
	}
	
}