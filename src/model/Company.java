package model;

import java.util.ArrayList;
import java.util.Collections;

import model.user.Employee;

public class Company implements Comparable<Company>{
	private ArrayList<Employee> employees;
	private String name;
	private Credit credit;
	
	public Company(String name) {
		this.name = name;
		this.employees = new ArrayList<Employee>();
		this.credit = new Credit(0.5);
	}
	
	public Company(String name, ArrayList<Employee> list) {
		this.name = name;
		this.employees = list;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	
	public void addEmployee(Employee emp) {
		employees.add(emp);
		Collections.sort(employees);
	}
	
	public void removeEmployee(Employee emp) {
		employees.remove(emp);
		Collections.sort(employees);
	}
	
	public Credit getCredit() {
		return credit;
	}
	
	public void setCredit(double credit) {
		this.credit = new Credit(credit);
	}
	
	@Override
	public int compareTo(Company o) {
		return this.name.compareTo(o.name);
	}
	
}
