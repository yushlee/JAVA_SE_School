

public class Employee {
	
	public String empName;
	
	public String title;
	
	public int empNumber;
	
	public Employee(){}
	
	public Employee(int number) {
		System.out.println( "員工編號:" + number);		
		empNumber =  number;
		// ...
	}
	
	
	public Employee(int number, String name) {
		System.out.println( "員工編號:" + number);
		empNumber =  number;
		empName = name;
	}
	
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