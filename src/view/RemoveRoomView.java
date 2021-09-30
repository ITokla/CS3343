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
}
