package model;

import model.user.Employee;

public class Session {
	private Employee emp;
	public Session(Employee emp) {
		this.emp = emp;
	}
	
	public Employee getEmployee() {
		return emp;
	}
}
