package controller.admin.report;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import model.Room;
import model.RoomBooking;
import system.MCRB;
import view.report.DateReportView;


public class DateReport extends Report {
	
	private DateReportView view;
	
	public DateReport() {
		view = new DateReportView();
	}
	
	public void execute(String[] args) {
		
		try {
			if(args.length < 1) 
				throw new NumberFormatException();
				
			LocalDate date = LocalDate.parse(args[0]);
			MCRB instance = MCRB.getInstance();
					
			ArrayList<Room> rooms = instance.getRooms();
			ArrayList<RoomBooking> rbs = instance.getRoomBookingByDate(date);
			
			view.printHeader();
			// view.printReportMonth(date);
			view.printContent(rooms, rbs, date);
			
			view.printFooter();
			
		}catch(Exception e) {
			System.out.println("Can't read the date");
		}
	}
	
}
