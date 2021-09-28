package model.user;

import java.security.NoSuchAlgorithmException;

import model.user.permission.EmployeePermission;
import model.user.permission.Permission;

public class Employee implements Comparable<Employee>{
	
	private String empId;
	private String username;
	private String pwd;
	private boolean init;
	protected Permission permission;
	
	public Employee(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
		this.init = true;
		setPermission();
	}
	
	public void setEmployee(Employee employee) {
		this.username = employee.username;
		this.pwd = employee.pwd;
		this.init = employee.init;
	}
	
	public boolean getInit() {
		return this.init;
	}
	
	public void setInit(boolean init) {
		this.init = init;
	}
	
	public void setPermission() {
		permission = EmployeePermission.getInstance();
	}
	
	public void setPassword(String hashedPassword) {
		this.pwd = hashedPassword;
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
		return username.compareTo(employee.username);
	}
	
	public Permission getPermission() {
		return permission;
	}

}
