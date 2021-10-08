package controller.admin;

import java.util.ArrayList;

import controller.Controller;
import model.Company;
import system.MCRB;
import view.ExtraCreditView;


public class ExtraCreditController extends Controller{
	private ExtraCreditView view;
	public ExtraCreditController(ExtraCreditView view) {
		this.view = view;
	}
	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		int index = 0;
		
		// Search company by input name
		ArrayList<Company> companys = MCRB.getInstance().searchCompany(view.getCompanyName());
		if(companys.size() == 0) {
			view.showMessage("Company not found");
			return;
		}
		index = view.selectList(companys);
		
		// index == size mean EXIT
		if(index == companys.size())
			return;
		
		double credit = view.getCredit();
		if (credit < 1) {
			view.showMessage("Credit update must be >= 1");
			return;
		}
		
		Company company = companys.get(index);
		company.getCredit().setMinute(company.getCredit().toMinutes() + credit*60);
		view.showMessage( company.getName() + " Credit updated.");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Extra Credit";
	}

}
