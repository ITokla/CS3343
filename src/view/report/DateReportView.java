package view.report;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Room;
import model.RoomBooking;
import view.RoomBookingView;

public class DateReportView extends ReportView{
	
	public void printContent(ArrayList<Room> rooms, ArrayList<RoomBooking> rbs, LocalDate date) {
		if(rooms.size() == 0 || rbs.size() == 0) 
			System.out.println("No any Records.");
		else {
			RoomBookingView.showDateRoomingDetails(date, rooms, rbs);
			
			for(Room rm: rooms) {
				
				System.out.println("\n--------Room" + rm.getRoomName() + "---------");
				rbs.forEach(rb -> {
					if(rb.getRoom() == rm)
						System.out.println(rb);
				});
				System.out.println("-----------------------------------\n");
				System.out.println();
			}
		}
	}

}
