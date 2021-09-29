package controller.admin;

import controller.Controller;
import system.CRB;
import view.UserRemoveView;

public class UserRemoveController extends Controller{
	
	private UserRemoveView view;
	
	public UserRemoveController(UserRemoveView view) {
		this.view = view;
	}
	
	public void execute() {
		String username = view.getEmployee();
		CRB.getInstance().removeEmployee(CRB.getInstance().searchEmployee(username));
		view.showMessage("Remove suceeful");
	}
	
	public String getDescription() {
		return "Remove User";
	}
	
}
