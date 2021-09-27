package controller;
import java.security.NoSuchAlgorithmException;


import model.Employee;
import model.Hash;
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
	
	public String getDescription() {
		return "Create Employee";
	}
	
}
