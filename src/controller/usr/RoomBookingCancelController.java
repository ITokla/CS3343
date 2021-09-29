package controller.usr;

import java.text.ParseException;
import java.util.ArrayList;

import controller.Controller;

import java.time.LocalDate;

import model.Credit;
import model.RoomBooking;
import system.MCRB;
import util.Time;
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
			
			if(employeeBookings == null || employeeBookings.size() == 0) {
				view.showMessage("Not found.");
				return;
			}
			
			int selectedIndex = 0;
			// If found more than 1 booking in date, let user select
			if (employeeBookings.size() > 1) {
				view.showMessage("More than 1 found.");
				selectedIndex = view.selectList(employeeBookings);
			}
			
			MCRB instance = MCRB.getInstance();
			RoomBooking preRemoveRoomBooking = employeeBookings.get(selectedIndex);
			view.showRoomBookingDetails(preRemoveRoomBooking);
			
			// Confirm [Y/n]
			if(view.confirmCancel()) {
				instance.removeRoomBooking(preRemoveRoomBooking);
				view.showMessage("Room booking cancel");
				long time = Time.durationMinutes(preRemoveRoomBooking.getStartTime(), preRemoveRoomBooking.getEndTime());
				Credit credit = instance.searchCompany(instance.getSession().getEmployee()).getCredit();
				credit.setMinute(credit.toMinutes() + time);
				view.showMessage("Company Credit update: " + credit.toMinutes());
			}
		} catch(ParseException e) {
			System.out.println("Please enter correct format: yyyy-MM-dd");
		}
		
	}
		

	public ArrayList<RoomBooking> searchRoomBooking(LocalDate date){
		System.out.println(MCRB.getInstance().getSession().getEmployee().getUsername());
		return MCRB.getInstance().searchCompanyRoomBookig(date, MCRB.getInstance().getSession().getEmployee());
	}
	
	public String getDescription() {
		return "Cancel Booking";
	}
}
