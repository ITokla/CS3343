package factory;

import java.util.ArrayList;
import model.Room;

public class RoomDBOFactory {
	public static ArrayList<Room> create(){
		ArrayList<Room> list = new ArrayList<>();
		list.add(new Room("rm601"));
		list.add(new Room("602"));
		list.add(new Room("s603"));
		list.add(new Room("604"));
		list.add(new Room("605"));
		list.add(new Room("sss606"));
		list.add(new Room("607"));
		
		return list;
	}
}
