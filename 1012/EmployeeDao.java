package com.training.session6;

/**
 * DAO設計模式用於資料儲存時分離「商業邏輯」(EX:顧客新增訂單儲存資料庫但不儲存檔案)
 * 和「資料保存機制」(EX:DB、File、Memory)，如此一來設計符合「單一責任制法則」(Single-Responsibility Principle)
 * 一旦類別若新增資料儲存商業邏輯規則，或是修改資料儲存方式，程式將更容易進行修改及擴充等彈性
 */
public interface EmployeeDao {
	
	/**
	 * 新增 Employee 回傳員工編號
	 * @param Employee
	 * @return int
	 */
	public int add(Employee e);
	
	/**
	 * 更新 Employee 回傳更新筆數
	 * @param Employee
	 * @return int
	 */
	public int update(Employee e);
	
	/**
	 * 刪除 Employee 回傳刪除筆數
	 * @param Employee
	 * @return int
	 */
	public int delete(int id);
	
	/**
	 * 查詢指定員工編號的Employee
	 * @param id
	 * @return Employee
	 */
	public Employee findById(int id);
	
	/**
	 * 查詢所有 Employee
	 * @return Employee[]
	 */
	public Employee[] getAllEmployees();

}
