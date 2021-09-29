package controller.usr;

import model.user.Employee;
import system.MCRB;
import view.UserManageView;

public class PasswordSetupController {
	private UserManageView view;
	public PasswordSetupController(UserManageView view) {
		this.view = view;
	}
	
	public void execute() {
		MCRB.getInstance().getSession().getEmployee().setPassword(view.initPassword());
	}
	
	public static void initPassowrd(Employee employee) {
		employee.setInit(true);
	}
	
}
