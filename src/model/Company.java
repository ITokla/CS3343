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
	@Override
	public int compareTo(Company o) {
		return this.name.compareTo(o.name);
	}
	
}
