package view.report;

import java.util.ArrayList;

import model.RoomBooking;

public class RoomReportView extends ReportView{

	
	public void printContent(ArrayList<RoomBooking> rooms) {
		rooms.forEach(System.out::println);
	}
	
}
