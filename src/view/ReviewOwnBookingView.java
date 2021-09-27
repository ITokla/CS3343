package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.RoomBooking;

public class ReviewOwnBookingView extends View{
	public ReviewOwnBookingView(Scanner input) {
		super(input);
	}
	
	public void printRoomBooking(ArrayList<RoomBooking> list) {
		for(RoomBooking rb: list)
			System.out.println(rb);
	}
}
