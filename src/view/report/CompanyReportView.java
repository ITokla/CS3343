package view.report;

import java.util.ArrayList;

import model.Company;
import model.RoomBooking;

public class CompanyReportView extends ReportView{
		
	public void printContent(ArrayList<RoomBooking> rbs ) {
		
		if(rbs.size() == 0) 
			System.out.println("No any room booking record");
		
		rbs.forEach(System.out::println);
	}
	
	public void printHeader(Company cmp) {
		super.printHeader();
		System.out.println("Company Name: " + cmp.getName());
		System.out.println("Credit: " + cmp.getCredit().toMinutes());
	}

}
