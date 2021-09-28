package controller;

import system.CRB;
import view.UserRemoveView;

public class UserRemoveController extends Controller{
	
	private UserRemoveView view;
	
	public UserRemoveController(UserRemoveView view) {
		this.view = view;
	}
	
	public void execute() {
		String empId = view.getEmployeeId();
		CRB.getInstance().removeEmployee(CRB.getInstance().searchEmployeeById(empId));
	}
	
	public String getDescription() {
		return "Remove User";
	}
	
}
