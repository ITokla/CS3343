package controller.admin;

import java.util.ArrayList;

import controller.Controller;
import model.Company;
import system.MCRB;
import view.CompanyRemoveView;

public class CompanyRemoveController extends Controller{
	
	protected CompanyRemoveView view;
	public CompanyRemoveController(CompanyRemoveView view) {
		this.view = view;
	}
	
	public void execute() {
		String cmpName = view.getCompanyName();
		ArrayList<Company> cmpList = MCRB.getInstance().searchCompany(cmpName);
		if(cmpList == null) {
			view.showMessage("not found");
			return;
		}
		
		if(cmpList.size() == 0) {//test1
			view.showMessage("Not found.");
			return;
		}
		
		int index = view.selectList(cmpList);
	
		if(index == cmpList.size())
			return; // exit
		if(view.Confirm()) {//test2
			MCRB.getInstance().removeRoomBookingByCompany(cmpList.get(index));
			MCRB.getInstance().removeCompany(cmpList.get(index));
			view.showMessage("Company Removed.");
		}
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Remove Company";
	}
	
	
	
}
