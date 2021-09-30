package controller.admin;

import controller.Controller;
import model.user.Employee;
import system.MCRB;
import util.Generator;
import util.Hash;
import view.UserPasswordResetView;

public class UserPasswordResetController extends Controller{

	private UserPasswordResetView view;
	public UserPasswordResetController(UserPasswordResetView view) {
		this.view = view;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String username = this.view.getEmployee();
		Employee employee = MCRB.getInstance().searchEmployee(username);
		if(employee == null)
			view.showMessage("User not found.");
		String password = Generator.generatePwd(8);
		view.showMessage("Please mark the new password: " + password);
		view.showMessage("You needs to reset password in first time login.");
		employee.setPassword(Hash.md5(password));
		employee.setInit(true);
		
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "User Password Reset";
	}

}
