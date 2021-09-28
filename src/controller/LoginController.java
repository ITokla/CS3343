package controller;

import java.util.Collections;

import model.user.Employee;
import system.CRB;
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
			CRB.getInstance().createSession(emp);
			view.showMessage("Login successful");
			
			if(emp.getInit()) {
				
				view.showMessage("\nSetup new Password");
				String password = this.view.initPassword();
				emp.setPassword(password);
				emp.setInit(false);
			}
				
			
		} else
			view.showMessage("Username or Password incorrect");

	}

	public Employee login(Employee emp) {
		// For testing, remove md5(pwd);
		String hashedPassword = Hash.md5(emp.getPassword());
		// search Employee
		Employee employee = CRB.getInstance().searchEmployee(emp.getUsername());
		return (employee != null && verify(employee, hashedPassword)) ? employee : null;
	}

	public boolean verify(Employee employee, String hashedPassword) {
		return employee.getPassword().equals(hashedPassword) ? true : false;
	}
	
	public String getDescription() {
		return "Login";
	}

}
