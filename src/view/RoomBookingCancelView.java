package view;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import model.RoomBooking;

public class RoomBookingCancelView extends View{
	
	public RoomBookingCancelView(Scanner input) {
		super(input);
	}
	
	// Input Cancel Date
	public LocalDate getCancelDate() throws ParseException{
		System.out.print("Please you want to cancel date: ");
		return formatDate(input.nextLine());
	}
	
	public LocalDate formatDate(String dateString) throws ParseException{
		return LocalDate.parse(dateString);
	}
	
	public boolean confirmCancel() {
		System.out.print("Confirm delete?[Y/n]");
		String confirm = input.nextLine();
		return (confirm.equals("Y")) ? true : false;
	}
	
	public void showRoomBookingDetails(RoomBooking rb) {
		System.out.println(rb);
	}
}
