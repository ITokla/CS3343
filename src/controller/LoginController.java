package controller;

import java.util.Collections;

import model.Employee;
import model.Hash;
import system.CRB;
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
		} else
			view.showMessage("Username or Password incorrect");

	}

	public Employee login(Employee emp) {
		// For testing, remove md5(pwd);
		String hashedPassword = Hash.md5(emp.getPassword());

		// search Employee
		int index = Collections.binarySearch(CRB.getInstance().getEmployeeList(),
				new Employee(emp.getUsername(), hashedPassword));
		if (index < 0)
			return null;
		Employee employee = CRB.getInstance().getEmployeeList().get(index);
		return verify(employee, hashedPassword) ? employee : null;
	}

	public boolean verify(Employee employee, String hashedPassword) {
		return employee.getPassword().equals(hashedPassword) ? true : false;
	}
	
	public String getDescription() {
		return "Login";
	}

}
