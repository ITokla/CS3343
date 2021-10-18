package controller;

import model.user.Employee;
import system.MCRB;
import util.Hash;
import view.LoginView;

public class LoginController extends Controller {

	private LoginView view;

	public LoginController(LoginView view) {
		this.view = view;
	}

	public void execute() {

		Employee emp = login(view.getLoginUser());
		if (emp != null) {
			
			if(emp.getStatus() == 2) {
				view.showMessage("User locked.\n");
				return;
			}
			
			MCRB.getInstance().createSession(emp);
			view.showMessage("Login successful");
			
			if(emp.getInit()) {
				view.showMessage("\nSetup new Password");
				String password = this.view.initPassword();
				emp.setPassword(password);
				emp.setStatus(1);
			}
			
		} else
			view.showMessage("Username or Password incorrect");

	}

	public Employee login(Employee emp) {
		// For testing, remove md5(pwd);
		String hashedPassword = Hash.md5(emp.getPassword());
		emp.setPassword(hashedPassword);
		return MCRB.getInstance().login(emp);
	}


	
	public String getDescription() {
		return "Login";
	}

}
