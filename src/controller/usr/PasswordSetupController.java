package controller.usr;

import model.user.Employee;
import system.CRB;
import view.UserManageView;

public class PasswordSetupController {
	private UserManageView view;
	public PasswordSetupController(UserManageView view) {
		this.view = view;
	}
	
	public void execute() {
		CRB.getInstance().getSession().getEmployee().setPassword(view.initPassword());
	}
	
	public static void initPassowrd(Employee employee) {
		employee.setInit(true);
	}
	
}
