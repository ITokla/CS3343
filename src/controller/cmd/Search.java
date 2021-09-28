package controller.cmd;

import java.util.ArrayList;
import java.util.Collections;

import model.RoomBooking;

public abstract class Search {
	
	enum Sort{
		ASC, DESC;
	}
	
	public abstract void execute(String[] cmds);
	
	public ArrayList<RoomBooking> sort(ArrayList<RoomBooking> arrayList, Sort sort){
		if(sort.equals(Sort.ASC)) 
			Collections.sort(arrayList);
		else
			Collections.sort(arrayList, Collections.reverseOrder());
		return arrayList;		
	}
	
	public void printRoomBookings(ArrayList<RoomBooking> list) {
		if(list.size() < 1) {
			System.out.println("No any record found.");
		}else {
			for(RoomBooking rb: list)
				System.out.println(rb);
		}
	}
	
	public Sort getSortType(String type) {
		return (type.equalsIgnoreCase("ASC"))? Sort.ASC : Sort.DESC;
	}
}

