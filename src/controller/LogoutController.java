package controller;

import system.MCRB;
import view.LogoutView;

public class LogoutController extends Controller{
	
	private LogoutView view;
	
	public LogoutController(LogoutView view) {
		this.view = view;
	}
	
	public void execute() {
		MCRB.getInstance().clearSession();
//		view.showMessage("Logouted\n"); 30/10 bug
		view.showMessage("Logouted");
	}
	
	public String getDescription() {
		return "Logout";
	}
}
