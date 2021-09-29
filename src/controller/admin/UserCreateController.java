package controller.admin;

import controller.Controller;
import model.user.Administrator;
import model.user.Employee;
import system.CRB;
import util.Generator;
import util.Hash;
import view.UserCreateView;

public class UserCreateController extends Controller {
	private UserCreateView view;
	public UserCreateController(UserCreateView view) {
		this.view = view;
	}
	
	
	public void execute() {
		
		String username;
		Employee emp = null;
		do {
			username = view.getUsername();
			emp = CRB.getInstance().searchEmployee(username);
			if(emp != null)
				view.showMessage("Username is already");
		}while(emp != null);
		
		String password = Generator.generatePwd(8);
		CRB.getInstance().regEmployee(new Employee(username, Hash.md5(password)));
		
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
