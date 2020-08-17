
public class EmployeeMain {

	public static void main(String[] args) {
		Employee jay = new Employee();
		jay.empName = "週杰輪";
		jay.title = "總經理";
		jay.empNumber = 1;
		System.out.println(jay.empName);
		jay.showEmployee();
		
		int basicSalary = 60000;
		int monthlySalary = jay.calculateSalary(basicSalary);
		System.out.println(monthlySalary);
		
		System.out.println(jay.calculateSalary(basicSalary));
		
		Employee jolin = new Employee();
		jolin.empName = "蔡依零";
		jolin.title = "特助";
		jolin.empNumber = 2;
		jolin.showEmployee();
	}

}
