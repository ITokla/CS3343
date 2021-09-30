package controller.admin.report;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import model.Room;
import model.RoomBooking;
import system.MCRB;
import view.report.RoomReportView;

public class RoomReport extends Report{
	
	private RoomReportView view;
	
	public RoomReport() {
		this.view = new RoomReportView();
	}
	
	@Override
	public void execute(String[] args) {
		// TODO Auto-generated method stub
		if(args.length< 1) {
			System.out.println(args[0] + " not found.");
			return;
		}
		LocalDate date = (args.length == 1)? LocalDate.now(): parseDate(args[1]);
		ArrayList<RoomBooking> rooms = MCRB.getInstance().getRoomBookingByRoomNameAndMonth(args[0], date);		
		
		view.printHeader();
		view.printReportMonth(date);
		view.printContent(rooms);
		view.printFooter();
	}
	
}
