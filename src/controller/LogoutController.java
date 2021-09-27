package controller;

import system.CRB;
import view.LogoutView;

public class LogoutController extends Controller{
	
	private LogoutView view;
	
	public LogoutController(LogoutView view) {
		this.view = view;
	}
	
	public void execute() {
		CRB.getInstance().clearSession();
		view.showMessage("Logouted\n");
	}
	
	public String getDescription() {
		return "Logout";
	}
}
