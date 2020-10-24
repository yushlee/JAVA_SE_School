package session2;

public class EmployeeMain {

	public static void main(String[] args) {
		
		Employee jay = new Employee(); 
		jay.empNumber = 1;
		jay.name = "JAY";
		jay.title = "總經理";
		
//		System.out.println(jay.empNumber);
//		System.out.println(jay.name);
//		System.out.println(jay.title);
		jay.showEmployee();
		
		int totalSalary = jay.calculateSalary(50000, 20);
		totalSalary = totalSalary + 2000; 
		
		System.out.println(totalSalary);
		
		System.out.println("=====================");
		
		Employee jolin = new Employee(2, "助理");
//		jolin.empNumber = 2;
		jolin.name = "JOLIN";
//		jolin.title = "助理";

		jolin.showEmployee();

		System.out.println(jolin.calculateSalary(22000, 0));
		
		System.out.println("=====================");
		
		Employee trump = new Employee(3, "美國總統");
//		trump.empNumber = 3;
		trump.name = "川普";
//		trump.title = "美國總統";
		
		trump.showEmployee();
	}

}
