package model;

import java.util.ArrayList;
import java.util.Collections;

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
		Collections.sort(list);
		int index = Collections.binarySearch(list, new Room(roomName));
		
		return (index < 0)? null : list.get(index);
	}
	
}
