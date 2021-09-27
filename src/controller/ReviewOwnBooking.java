package controller;

import system.CRB;
import view.ReviewOwnBookingView;

public class ReviewOwnBooking extends Controller{
	private ReviewOwnBookingView view;
	public ReviewOwnBooking(ReviewOwnBookingView view) {
		this.view = view;
	}
	
	public void execute() {
		view.printRoomBooking(CRB.getInstance().getRoomBookingByEmployee(CRB.getInstance().getSession().getEmployee()));
	}
	
	public String getDescription() {
		return "Review Own Booking";
	}
}
