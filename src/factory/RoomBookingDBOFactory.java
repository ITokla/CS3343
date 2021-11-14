package factory;

import java.util.ArrayList;
import java.util.Collections;

import model.Room;
import model.RoomBooking;
import model.user.Employee;
import system.MCRB;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RoomBookingDBOFactory {
	public static ArrayList<RoomBooking> create(){
		ArrayList<RoomBooking> list = new ArrayList<RoomBooking>();
		Employee testEmp1 = MCRB.getInstance().searchEmployee("cp3test");
		Employee testEmp2 = MCRB.getInstance().searchEmployee("cp3test1");
		Room testRm = MCRB.getInstance().searchRoom("RoomHasBook");
		list.add(new RoomBooking(testEmp1,LocalDateTime.of(2022,1,1, 12,0,0),LocalDateTime.of(2022,1,1, 13,0,0),testRm));
		list.add(new RoomBooking(testEmp2,LocalDateTime.of(2022,1,1, 12,0,0),LocalDateTime.of(2022,1,1, 13,0,0),testRm));
		list.add(new RoomBooking(testEmp2,LocalDateTime.of(2022,1,1, 12,0,0),LocalDateTime.of(2022,1,1, 13,0,0),testRm));
		list.add(new RoomBooking(testEmp2,LocalDateTime.of(2000,1,1, 12,0,0),LocalDateTime.of(2000,1,1, 13,0,0),testRm));
		list.add(new RoomBooking(testEmp2,LocalDateTime.of(2000,1,1, 16,0,0),LocalDateTime.of(2000,1,1, 17,0,0),testRm));
//		list.add(new RoomBooking(emp, LocalDateTime.of(2021,9,26, 12,30,0), LocalDateTime.of(2021, 9, 26, 13, 30,0)));
//		list.add(new RoomBooking(new Employee("a", "tes"), LocalDateTime.of(2021,9,26, 9,0,0), LocalDateTime.of(2021, 9, 26, 12, 30,0)));
//
//		list.add(new RoomBooking(emp, LocalDateTime.of(2021,9,26, 13,30,0), LocalDateTime.of(2021, 9, 26, 14, 30,0)));
//		list.add(new RoomBooking(emp, LocalDateTime.of(2021,9,27, 13,30,0), LocalDateTime.of(2021, 9, 27, 14, 30,0)));
		
		Collections.sort(list);
		return list;
	}
}
