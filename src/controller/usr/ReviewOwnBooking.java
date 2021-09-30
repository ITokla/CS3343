package controller.usr;

import controller.Controller;
import system.MCRB;
import view.ReviewOwnBookingView;

public class ReviewOwnBooking extends Controller{
	private ReviewOwnBookingView view;
	public ReviewOwnBooking(ReviewOwnBookingView view) {
		this.view = view;
	}
	
	public void execute() {
		view.printRoomBooking(MCRB.getInstance().getRoomBookingByEmployee(MCRB.getInstance().getSession().getEmployee()));
	}
	
	public String getDescription() {
		return "Review Own Booking";
	}
}
