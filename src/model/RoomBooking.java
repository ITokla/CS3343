package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import model.user.Employee;

public class RoomBooking implements Comparable<RoomBooking>{
	
	private Employee employee;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private Room room;
	
	public RoomBooking(Employee employee, LocalDateTime startDateTime, LocalDateTime endDateTime, Room room) {
		this.employee = employee;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.room = room;
	}
	
	public int compareTo(RoomBooking roomBooking) {
		return this.startDateTime.compareTo(roomBooking.startDateTime);
	}
	
	public String toString() {
		return "Booked by: " + employee.getUsername() + "\nStart datetime: " + startDateTime + "\nEnd datetime: " + endDateTime;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public LocalTime getStartTime() {
		return startDateTime.toLocalTime();
	}
	
	public LocalTime getEndTime() {
		return endDateTime.toLocalTime();
	}

	public static ArrayList<RoomBooking> getRoomBookingByEmployee(ArrayList<RoomBooking> list, Employee employee){
		ArrayList<RoomBooking> employeeRoomBookings = new ArrayList<RoomBooking>();
		for(RoomBooking rb: list) {
			if(rb.employee == employee)
				employeeRoomBookings.add(rb);
		}
		return employeeRoomBookings;
	}
	
	public static ArrayList<RoomBooking> getRoomBookingByEmployeeAndDate(ArrayList<RoomBooking> list, Employee employee, LocalDate date){
		ArrayList<RoomBooking> employeeRoomBookings = new ArrayList<>();
		for(RoomBooking rb: list) {
			if(rb.employee == employee && rb.startDateTime.toLocalDate().isEqual(date))
				employeeRoomBookings.add(rb);
		}
		return employeeRoomBookings;
	}
	
	
	public static ArrayList<RoomBooking> getRoomBookingByDate(ArrayList<RoomBooking> list, LocalDate date){
		ArrayList<RoomBooking> employeeRoomBookings = new ArrayList<>();
		for(RoomBooking rb: list) {
			if(rb.startDateTime.toLocalDate().isEqual(date))
				employeeRoomBookings.add(rb);
		}
		return employeeRoomBookings;
	}
	
	public static ArrayList<RoomBooking> getRoomBooking(ArrayList<RoomBooking> list, LocalDate date, Room room){
		ArrayList<RoomBooking> employeeRoomBookings = new ArrayList<>();
		for(RoomBooking rb: list) {
			if(rb.startDateTime.toLocalDate().isEqual(date) && rb.room == room)
				employeeRoomBookings.add(rb);
		}
		return employeeRoomBookings;
	}
	
	public static ArrayList<RoomBooking> getRoomBookingByRoomName(ArrayList<RoomBooking> list, String roomName){
		return new ArrayList<RoomBooking>(list.stream().filter((RoomBooking rb) -> rb.room.getRoomName().toLowerCase().contains(roomName.toLowerCase())).collect(Collectors.toList()));
	}
	


}
