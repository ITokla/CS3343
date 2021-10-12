package controller.admin.report;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import model.Company;
import model.RoomBooking;
import system.MCRB;
import view.report.CompanyReportView;

public class CompanyReport extends Report {
	
	private CompanyReportView view;
	public CompanyReport() {
		view = new CompanyReportView();
	}
	
	public void execute(String[] args) {
		
		if(args.length< 1) {
			view.showMessage("Can't search the Company");
			return;
		}
		
		Company cmp = MCRB.getInstance().getCompany(args[0]);
		if(cmp == null) {
			view.showMessage(args[0] + " not Found");
			return;
		}
		
		LocalDate date = (args.length == 1)? LocalDate.now(): parseDate(args[1]);
		ArrayList<RoomBooking> rbs = MCRB.getInstance().getRoomBookingByMonthAndCompany(date, cmp);
		
		view.printHeader(cmp);
		view.printReportMonth(date);
		view.printContent(rbs);
		view.printFooter();
		
		
	}
	

}
