package view;

import java.util.Scanner;

public class RemoveRoomView extends View{
	
	public RemoveRoomView(Scanner input) {
		super(input);
	}
	
	public String getRoomName() {
		System.out.print("Enter Roomname: ");
		return input.nextLine();
	}
	
	public void showCountOfRemovedRoomBooking(int number) {
		System.out.printf("Removed %d Room Booking\n", number);
	}
}
