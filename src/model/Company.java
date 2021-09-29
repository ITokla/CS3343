package model;

import java.util.ArrayList;

import model.user.Employee;

public class Company implements Comparable<Company>{
	private ArrayList<Employee> emp;
	private String name;
	
	public Company(String name) {
		this.name = name;
		this.emp = new ArrayList<Employee>();
	}
	
	public Company(String name, ArrayList<Employee> list) {
		this.name = name;
		this.emp = list;
	}
	
	public ArrayList<Employee> getEmployees(){
		return emp;
	}
	
	@Override
	public int compareTo(Company o) {
		return this.name.compareTo(o.name);
	}
	
}
