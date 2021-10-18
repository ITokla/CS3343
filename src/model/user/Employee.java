package model.user;

import java.util.ArrayList;
import java.util.Collections;

import model.user.permission.EmployeePermission;
import model.user.permission.Permission;

public class Employee implements Comparable<Employee>{
	
	private String empId;
	private String username;
	private String pwd;
	private int status;
	/*
	 * 0 = new user/ need reset password
	 * 1 = normal user
	 * 2 = locked
	 */
	protected Permission permission;
	
	public Employee(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
		this.status = 0;
		setPermission();
	}
	
	public void setEmployee(Employee employee) {
		this.username = employee.username;
		this.pwd = employee.pwd;
		this.status = employee.status;
	}
	
	public int getStatus() {
		return status;
	}
	
	public boolean getInit() {
		if(this.status < 1)
			return true;
		return false;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setPermission() {
		permission = EmployeePermission.getInstance();
	}
	
	public void setPassword(String hashedPassword) {
		this.pwd = hashedPassword;
	}
	
	public void setInit(boolean init) {
		this.status = (init)? 0: 1;
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
	
	public void lock(boolean status) {
		this.status = (status)? 2: 1;
	}
	
	public int compareTo(Employee employee) {
		return username.compareTo(employee.username);
	}
	
	public Permission getPermission() {
		return permission;
	}
	
	public static Employee search(ArrayList<Employee> emps, String username) {
		int index = Collections.binarySearch(emps, new Employee(username, null));
		return (index < 0)? null : emps.get(index);
	}

}
