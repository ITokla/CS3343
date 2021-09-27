package factory;

import java.util.ArrayList;

import model.Employee;
import model.RoomBooking;


public class RoomBookingDBOFactory {
	public static ArrayList<RoomBooking> create(Employee emp){
		ArrayList<RoomBooking> list = new ArrayList<RoomBooking>();
//		list.add(new RoomBooking(emp, LocalDateTime.of(2021,9,26, 9,0,0), LocalDateTime.of(2021, 9, 26, 12, 30,0)));
//		list.add(new RoomBooking(emp, LocalDateTime.of(2021,9,26, 12,30,0), LocalDateTime.of(2021, 9, 26, 13, 30,0)));
//		list.add(new RoomBooking(new Employee("a", "tes"), LocalDateTime.of(2021,9,26, 9,0,0), LocalDateTime.of(2021, 9, 26, 12, 30,0)));
//
//		list.add(new RoomBooking(emp, LocalDateTime.of(2021,9,26, 13,30,0), LocalDateTime.of(2021, 9, 26, 14, 30,0)));
//		list.add(new RoomBooking(emp, LocalDateTime.of(2021,9,27, 13,30,0), LocalDateTime.of(2021, 9, 27, 14, 30,0)));
		return list;
	}
}
