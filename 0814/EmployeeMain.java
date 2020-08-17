
public class EmployeeMain {

	public static void main(String[] args) {
		Employee jay = new Employee(1, "週杰輪");
//		jay.empName = "週杰輪";
		jay.title = "總經理";
		// jay.empNumber = 1;
		System.out.println(jay.empName);
		jay.showEmployee();
		
		int basicSalary = 60000;
		int monthlySalary = jay.calculateSalary(basicSalary);
		System.out.println(monthlySalary);		
		System.out.println(jay.calculateSalary(basicSalary));
		
		System.out.println("=========================================");
		
		Employee jolin = new Employee(2, "蔡依零");
//		jolin.empName = "蔡依零";
		jolin.title = "特助";
//		jolin.empNumber = 2;
		jolin.showEmployee();
		
		System.out.println("=========================================");
		
		Employee tom = new Employee(3);
//		tom.empName = "湯母";
		tom.title = "程式設計師";
		
		tom.showEmployee();
		
		Employee wendy = new Employee();
	}

}
