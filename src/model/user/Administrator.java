package model.user;

import model.user.permission.AdministratorPermission;

public class Administrator extends Employee{
	
	public Administrator(String username, String password) {
		super(username, password);
		this.permission = AdministratorPermission.getInstance();
	}
	
}
