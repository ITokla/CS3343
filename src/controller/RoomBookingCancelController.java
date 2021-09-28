package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;
import model.RoomBooking;
import system.CRB;
import view.RoomBookingCancelView;

public class RoomBookingCancelController extends Controller{
	
	private RoomBookingCancelView view;
	public RoomBookingCancelController(RoomBookingCancelView view) {
		this.view = view;
	}
	
	public void execute() {
		try {
			
			LocalDate date = view.getCancelDate();
			ArrayList<RoomBooking> employeeBookings = searchRoomBooking(date);
			
			if(employeeBookings.size() == 0) {
				view.showMessage("Not found.");
				return;
			}
			
			int selectedIndex = 0;
			// If found more than 1 booking in date, let user select
			if (employeeBookings.size() > 1) {
				view.showMessage("More than 1 found.");
				selectedIndex = view.getCancelRoomBookingIndex(employeeBookings);
			}
			
			CRB instance = CRB.getInstance();
			RoomBooking preRemoveRoomBooking = instance.getRoomBookingList().get(selectedIndex);
			view.showRoomBookingDetails(preRemoveRoomBooking);
			
			// Confirm [Y/n]
			if(view.confirmCancel()) {
				instance.removeRoomBooking(preRemoveRoomBooking);
				view.showMessage("Room booking cancel");
			}
		} catch(ParseException e) {
			System.out.println("Please enter correct format: yyyy-MM-dd");
		}
		
	}
		

	public ArrayList<RoomBooking> searchRoomBooking(LocalDate date){
		return CRB.getInstance().getRoomBookingBySessionAndDate(date);
	}
	
	public String getDescription() {
		return "Cancel Booking";
	}
}
