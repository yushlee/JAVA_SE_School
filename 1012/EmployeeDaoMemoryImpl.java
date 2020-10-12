package com.training.session6;

public class EmployeeDaoMemoryImpl implements EmployeeDao {


	private static EmployeeDaoMemoryImpl empDaoMemImpl = new EmployeeDaoMemoryImpl();


	private EmployeeDaoMemoryImpl(){}


	public static EmployeeDaoMemoryImpl getInstance(){
		return empDaoMemImpl;
	}

	@Override
	public int add(Employee e) {
		System.out.println("Adding to memory...");
		return 0;
	}

	@Override
	public int update(Employee e) {
		System.out.println("Updating to memory...");
		return 0;
	}

	@Override
	public int delete(int id) {
		System.out.println("Deleting from memory...");
		return 0;
	}

	@Override
	public Employee findById(int id) {
		System.out.println("find by memory...");
		return new Employee();
	}

	@Override
	public Employee[] getAllEmployees() {
		return new Employee[]{};
	}
}
