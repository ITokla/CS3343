package controller.admin;

import java.util.ArrayList;

import controller.Controller;
import model.user.Administrator;
import model.user.Employee;
import model.Company;
import system.MCRB;
import util.Generator;
import util.Hash;
import view.UserCreateView;


public class UserCreateController extends Controller {
	private UserCreateView view;
	public UserCreateController(UserCreateView view) {
		this.view = view;
	}
	
	
	public void execute() {
		
		int index = 0;
		
		// Search company by input name
		
			ArrayList<Company> companys = MCRB.getInstance().searchCompany(view.getCompanyName());
			if(companys.size() == 0) {
				view.showMessage("Company not found");
				return;
			}
			index = view.selectList(companys);
			
			// index == size mean EXIT
			if(index == companys.size())
				return;
			
		
		String username;
		Employee emp = null;
		
		do {
			username = view.getUsername();
			// check username whether repeat
			emp = MCRB.getInstance().searchEmployee(username);
			if(emp != null)
				view.showMessage("Username is already");
		}while(emp != null);
		
		// Generate random password
		String password = Generator.generatePwd(8);
		companys.get(index).addEmployee(createEmployee(username, password));
		
		System.out.println(username + " is created, init password: " + password);
		System.out.println("User need to reset password in login first time.");
		
	}

	public static Employee createEmployee(String username, String password) {
		return new Employee(username, Hash.md5(password));
	}
	
	public static Administrator createAdministrator(String username, String password) {
		return new Administrator(username, Hash.md5(password));
	}
	
	public String getDescription() {
		return "Create Employee";
	}
	
}
