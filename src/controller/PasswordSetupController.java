package controller;

import model.user.Employee;
import system.CRB;
import view.UserCreateView;

public class PasswordSetupController {
	private UserCreateView view;
	public PasswordSetupController(UserCreateView view) {
		this.view = view;
	}
	
	public void execute() {
		CRB.getInstance().getSession().getEmployee().setPassword(view.initPassword());
	}
	
	public static void initPassowrd(Employee employee) {
		employee.setInit(true);
	}
	
}
