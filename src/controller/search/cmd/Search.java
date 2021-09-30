package controller.search.cmd;

import java.util.ArrayList;
import java.util.Collections;

import model.RoomBooking;
import view.View;

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
		View.showAllRecords(list);
	}
	
	public Sort getSortType(String type) {
		return (type.equalsIgnoreCase("ASC"))? Sort.ASC : Sort.DESC;
	}
}

