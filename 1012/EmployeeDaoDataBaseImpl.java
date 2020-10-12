package com.training.session6;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.training.session1.DBConnectionFactory;

public class EmployeeDaoDataBaseImpl implements EmployeeDao {

	/**
	 * Singleton Pattern(單一實例化模式)
	 * 私有(private)的靜態(satatic)來儲存類別的實體,外部就無法直接存取
	 */
	private static EmployeeDaoDataBaseImpl empDaoDbImpl = new EmployeeDaoDataBaseImpl();
	
	/**
	 * 私有建構式:外部就不能使用new EmployeeDaoDataBaseImpl()來產生實體
	 */
	private EmployeeDaoDataBaseImpl(){}
	
	/**
	 * 建立公開取得物件實體方法,提供外部取得單一實例化物件
	 * @return EmployeeDaoDataBaseImpl
	 */
	public static EmployeeDaoDataBaseImpl getInstance(){
		return empDaoDbImpl;
	}
	
	/**
	 * DAO設計模式(各別資料保存機制實作)
	 * @param Employee
	 */
	@Override
	public int add(Employee emp) {
		System.out.println("Adding to DataBase...");
		int empNo = 0;
		String[] cols = { "EMPNO" };
		try (Connection conn = DBConnectionFactory.getHrDBConnection()){
			// 設置交易不自動提交
			conn.setAutoCommit(false);
			// Insert SQL			
			String insertSQL = "INSERT INTO EMP2 VALUES (EMP2_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			// Step2:Create prepareStatement For SQL
			try (PreparedStatement pstmt = conn.prepareStatement(insertSQL, cols)){
				// Step3:將"資料欄位編號"、"資料值"作為引數傳入				
				pstmt.setString(1, emp.getEname());
				pstmt.setString(2, emp.getJob());
				pstmt.setDate(3, new Date(emp.getHiredate().getTime()));
				pstmt.setFloat(4, emp.getSal());
				pstmt.setFloat(5, emp.getComm());
				pstmt.setInt(6, emp.getDeptno());
				// Step4:Execute SQL
				pstmt.executeUpdate();
				
				// 取對應的自增主鍵值
				ResultSet rsKeys = pstmt.getGeneratedKeys();
				rsKeys.next();
				empNo = rsKeys.getInt(1);
				
				// Step5:Transaction commit(交易提交)
				conn.commit();
			} catch (SQLException e) {
				// 若發生錯誤則資料 rollback(回滾)
				conn.rollback();
				throw e;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empNo;
	}

	@Override
	public int update(Employee emp) {
		System.out.println("Updating to DataBase...");
		int updateCount = 0;
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getHrDBConnection()){
			// 設置交易不自動提交
			conn.setAutoCommit(false);			
			// Update SQL
			String updateSql = "UPDATE EMP2 SET ENAME=?, JOB=?, HIREDATE=?, SAL=?, COMM=?, DEPTNO=? WHERE EMPNO=?";			
			// Step2:Create prepareStatement For SQL
			try (PreparedStatement stmt = conn.prepareStatement(updateSql)){
				// Step3:將"資料欄位編號"、"資料值"作為引數傳入
				stmt.setString(1, emp.getEname());
				stmt.setString(2, emp.getJob());
				stmt.setDate(3, new Date(emp.getHiredate().getTime()));
				stmt.setFloat(4, emp.getSal());
				stmt.setFloat(5, emp.getComm());
				stmt.setInt(6, emp.getDeptno());
				stmt.setInt(7, emp.getEmpno());
				// Step4:Execute SQL			
				updateCount = stmt.executeUpdate();				
				// Step5:交易提交
				conn.commit();	
			} catch (SQLException e) {
				// 發生 Exception 交易資料 roll back
				conn.rollback();
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updateCount;
	}

	@Override
	public int delete(int id) {
		System.out.println("Deleting from DataBase...");
		int delCount = 0;
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getHrDBConnection()){
			// 設置交易不自動提交
			conn.setAutoCommit(false);
			// DELETE SQL
			String deleteSql = "DELETE FROM EMP2 WHERE EMPNO = ?";			
			// Step2:Create prepareStatement For SQL			
			try (PreparedStatement stmt = conn.prepareStatement(deleteSql)){
				// Step3:將"資料欄位編號"、"資料值"作為引數傳入
				stmt.setInt(1, id);
				// Step4:Execute SQL
				delCount = stmt.executeUpdate();
				// Step5:交易提交
				conn.commit();
			} catch (SQLException e) {
				// 若發生錯誤則資料 rollback(回滾)
				conn.rollback();
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return delCount;
	}

	@Override
	public Employee findById(int id) {
		Employee emp = null;
		String querySQL = "SELECT * FROM EMP2 WHERE EMPNO = ?";
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getHrDBConnection();
			 // Step2:Create PreparedStatement For SQL
			 PreparedStatement stmt = conn.prepareStatement(querySQL)){
			// 設置查詢的欄位值
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()){				
				// Step3:Process Result
				while(rs.next()) {
					emp = new Employee();
					emp.setEmpno(rs.getInt("EMPNO"));
					emp.setEname(rs.getString("ENAME"));
					emp.setJob(rs.getString("JOB"));
					emp.setHiredate(rs.getDate("HIREDATE"));
					emp.setSal(rs.getFloat("SAL"));
					emp.setComm(rs.getFloat("COMM"));
					emp.setDeptno(rs.getInt("DEPTNO"));
					break;
				}	
			} catch (SQLException e) {
				throw e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public Employee[] getAllEmployees() {
		Employee[] emps = null;
		String querySQL = "SELECT * FROM EMP2";
		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getHrDBConnection();
				// Step2:Create Statement
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(querySQL)) {
			rs.last();
			int rowSize = rs.getRow();
			if(rowSize > 0){
				emps = new Employee[rowSize];
			}else{
				return emps;
			}
			// Step3:Process Result
			rs.beforeFirst();
			int count = 0;
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				emp.setHiredate(rs.getDate("HIREDATE"));
				emp.setSal(rs.getFloat("SAL"));
				emp.setComm(rs.getFloat("COMM"));
				emp.setDeptno(rs.getInt("DEPTNO"));
				emps[count] = emp;
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emps;
	}

}
