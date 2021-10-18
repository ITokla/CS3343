package controller.usr;

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
				view.showMessage("Not record found.");
				return;
			}
			
			int selectedIndex = 0;
			// If found more than 1 booking in date, let user select
			if (employeeBookings.size() > 1) {
				view.showMessage("More than 1 found.");
				selectedIndex = view.selectList(employeeBookings);
			}
			
			if(selectedIndex == employeeBookings.size())
				return;
			
			MCRB instance = MCRB.getInstance();
			RoomBooking preRemoveRoomBooking = employeeBookings.get(selectedIndex);
			view.showRoomBookingDetails(preRemoveRoomBooking);
			
			// Confirm [Y/n]
			if(view.Confirm()) {
				instance.removeRoomBooking(preRemoveRoomBooking);
				view.showMessage("Room booking cancel");
				long time = Time.durationMinutes(preRemoveRoomBooking.getStartTime(), preRemoveRoomBooking.getEndTime());
				Credit credit = instance.searchCompany(instance.getSession().getEmployee()).getCredit();
				credit.setMinute(credit.toMinutes() + time);
				view.showMessage("Company Credit update: " + credit.toMinutes());
			}
		} catch(Exception e) {
			System.out.println("Please enter correct format: yyyy-MM-dd" + e);
		}
		
	}
		

	public ArrayList<RoomBooking> searchRoomBooking(LocalDate date){
		ArrayList<RoomBooking> rb;
		if(MCRB.getInstance().isAdmin(MCRB.getInstance().getSession().getEmployee())) 
			rb = MCRB.getInstance().getRoomBookingByDate(date);
		else
			rb = MCRB.getInstance().searchCompanyRoomBookig(date, MCRB.getInstance().getSession().getEmployee());
		
		if(date.isBefore(MCRB.getInstance().getSystemDateTime().toLocalDate()) || date.isEqual(MCRB.getInstance().getSystemDateTime().toLocalDate()))
			rb = removeBeforeSystemTimeRoomBooking(rb);
		return rb;
	}
	
	
	public ArrayList<RoomBooking> removeBeforeSystemTimeRoomBooking(ArrayList<RoomBooking> rbs){
		ArrayList<RoomBooking> rmList = new ArrayList<RoomBooking>();
		for(RoomBooking rb:rbs) {
			if(rb.getStartTime().isBefore(MCRB.getInstance().getSystemDateTime().toLocalTime()))
				rmList.add(rb);
		}
		rbs.removeAll(rmList);
		return rbs;
	}
	
	public String getDescription() {
		return "Cancel Booking";
	}
}
