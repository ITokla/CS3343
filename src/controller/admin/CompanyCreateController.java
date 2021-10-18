package controller.admin;

import controller.Controller;
import model.Company;
import system.MCRB;
import view.CompanyCreateView;

public class CompanyCreateController extends Controller{
	protected CompanyCreateView view;
	
	public CompanyCreateController(CompanyCreateView view) {
		this.view = view;
	}
	
	public void execute() {
		String cmpName = view.getCreateCompanyName();
		if(MCRB.getInstance().getCompany(cmpName) != null) {
			view.showMessage("Company Name duplicated");
			return;
		}
		Company cmp = new Company(cmpName);
		MCRB.getInstance().addCompany(cmp);
		view.showMessage(cmpName+" is created.");
	}

	@Override
	public String getDescription() {
		return "Company Create";
	}
	
}
