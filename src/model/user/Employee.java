package model.user;

import java.security.NoSuchAlgorithmException;

import model.user.permission.EmployeePermission;
import model.user.permission.Permission;

public class Employee implements Comparable<Employee>{
	
	private String empId;
	private String username;
	private String pwd;
	protected Permission permission;
	
	public Employee(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
		setPermission();
	}
	
	public Employee(String empId, String username, String pwd) {
		this.empId = empId;
		this.username = username;
		this.pwd = pwd;
		setPermission();
	}
	
	public void setPermission() {
		permission = EmployeePermission.getInstance();
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return pwd;
	}
	
	public int compareTo(Employee employee) {
		return this.username.compareTo(employee.username);
	}
	
	public Permission getPermission() {
		return permission;
	}

}
