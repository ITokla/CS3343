package controller.admin;

import controller.Controller;
import view.AddCompanyView;

public class AddCompanyController extends Controller {
	private AddCompanyView view;
	
	public AddCompanyController(AddCompanyView view) {
		this.view = view;
	}
	
	public void execute() {
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Remove Company";
	}
	
	
}
