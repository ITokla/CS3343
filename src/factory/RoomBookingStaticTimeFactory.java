package factory;

import java.time.LocalTime;
import java.util.ArrayList;

public class RoomBookingStaticTimeFactory {
	public static ArrayList<LocalTime> create(){
		ArrayList<LocalTime> list = new ArrayList<>();
		LocalTime startTime = LocalTime.of(9, 0);
		LocalTime endTime = LocalTime.of(20, 30);
		while(startTime.isBefore(endTime)) {
			list.add(startTime);
			startTime = startTime.plusMinutes(30);
		}
		return list;
	}
}
