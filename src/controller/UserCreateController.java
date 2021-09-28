package controller;
import java.security.NoSuchAlgorithmException;

import model.Hash;
import model.user.Administrator;
import model.user.Employee;
import system.CRB;
import view.UserCreateView;

public class UserCreateController extends Controller {
	private UserCreateView view;
	public UserCreateController(UserCreateView view) {
		this.view = view;
	}
	
	
	public void execute() {
		try {
			CRB.getInstance().regEmployee(view.createEmployee());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			view.showMessage("Create User failed.");
		}
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
