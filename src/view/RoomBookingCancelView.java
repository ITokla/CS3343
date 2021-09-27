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
	
	public int getCancelRoomBookingIndex(ArrayList<RoomBooking> list) {
		for(int i = 0; i < list.size(); ) {
			System.out.printf("[%d]: ", i);
			System.out.println(list.get(i++));
		}
		System.out.print("Please enter index: ");
		
		// if there is input.nextInt(), next input will read "" only
		return Integer.parseInt(input.nextLine());
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
