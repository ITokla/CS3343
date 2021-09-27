package model;

import java.security.NoSuchAlgorithmException;

public class Employee implements Comparable<Employee>{
	
	private String empId;
	private String username;
	private String pwd;
	
	public Employee(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}
	
	public Employee(String empId, String username, String pwd) throws NoSuchAlgorithmException {
		this.empId = empId;
		this.username = username;
		this.pwd = pwd;
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

}
