package com.training.session6;

public class EmployeeDaoFileImpl implements EmployeeDao {

	private static EmployeeDaoFileImpl empDaoMemImpl = new EmployeeDaoFileImpl();

	private EmployeeDaoFileImpl(){}

	public static EmployeeDaoFileImpl getInstance(){
		return empDaoMemImpl;
	}
	
	@Override
	public int add(Employee e) {
		System.out.println("Adding to files...");
		return 0;
	}

	@Override
	public int update(Employee e) {
		System.out.println("Updating to files...");
		return 0;
	}

	@Override
	public int delete(int id) {
		System.out.println("Deleting from files...");
		return 0;
	}

	@Override
	public Employee findById(int id) {
		System.out.println("find by files...");
		return new Employee();
	}

	@Override
	public Employee[] getAllEmployees() {
		return new Employee[]{};
	}
}
