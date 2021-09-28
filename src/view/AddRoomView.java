package view;

import java.util.Scanner;

import model.Room;

public class AddRoomView extends View{
	public AddRoomView(Scanner input) {
		super(input);
	}
	public Room createRoom() {
		System.out.print("Room name: ");
		return new Room(input.nextLine());
	}
}
