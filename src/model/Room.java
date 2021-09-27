package model;

import java.util.ArrayList;

public class Room implements  Comparable<Room>{
	private String roomName;
	
	public Room(String roomNo) {
		this.roomName = roomNo;
	}
	
	public String getRoomName() {
		return roomName;
	}

	@Override
	public int compareTo(Room o) {
		return this.roomName.compareTo(o.roomName);
	}
	
	public static Room searchRoom(ArrayList<Room> list, String roomName) {
		
		for(Room room: list) {
			if(room.roomName.equals(roomName))
				return room;
		}
		return null;
	}
	
}
