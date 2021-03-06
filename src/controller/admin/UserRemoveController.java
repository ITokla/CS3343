package controller.admin;

import controller.Controller;
import model.user.Employee;
import system.MCRB;
import view.UserRemoveView;

public class UserRemoveController extends Controller{
	
	private UserRemoveView view;
	
	public UserRemoveController(UserRemoveView view) {
		this.view = view;
	}
	
	public void execute() {
		String username = view.getEmployee();
		
		Employee emp = MCRB.getInstance().searchEmployee(username);
		if(emp == null) {
			view.showMessage("Employee not found.");
			return;
		}
		
		emp.lock(true);
		view.showMessage("User locked.");
	}
	
	public String getDescription() {
		return "Lock User";
	}
	
}
