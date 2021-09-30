package system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import model.Room;
import model.Session;
import model.user.Employee;
import model.RoomBooking;

abstract class CRBCore {
	
	// private ArrayList<Employee> employeeList;
	private ArrayList<Room> roomList;
	protected ArrayList<RoomBooking> bookingList;
	private Session session;
	
	CRBCore() {
		// employeeList = new ArrayList<>();
//		employeeList = EmployeeDBOFactory.create();
		roomList = new ArrayList<Room>();
		bookingList = new ArrayList<RoomBooking>();
		session = null;
	}
	
	CRBCore(ArrayList<Room> roomList){
		this.roomList = roomList;
		bookingList = new ArrayList<RoomBooking>();
	}
	
	CRBCore(ArrayList<Room> roomList, ArrayList<RoomBooking> bookingList){
		this.roomList = roomList;
		this.bookingList = bookingList;
	}
	
	
	public void removeRoom(Room room) {
		roomList.remove(room);
		Collections.sort(roomList);
	}
	
	public void addRoom(Room room) {
		roomList.add(room);
		Collections.sort(roomList);
	}
	
	public void createSession(Employee emp) {
		if(emp != null)
			session = new Session(emp);
	}

	public Session getSession() {
		return session;
	}
	
	public RoomBooking addRoomBooking(Room room, LocalDate date, LocalTime startTime, LocalTime endTime) {
		RoomBooking rb = new RoomBooking(session.getEmployee(), LocalDateTime.of(date, startTime), LocalDateTime.of(date, endTime), room);;
		bookingList.add(rb);
		Collections.sort(bookingList);
		return rb;
	}
	
	public ArrayList<RoomBooking> getRoomBookingList(){
		return bookingList;
	}
	
	public void removeRoomBooking(RoomBooking rb) {
		bookingList.remove(rb);
	}
	
	public ArrayList<Room> getRooms(){
		return roomList;
	}
	
	public Room searchRoom(String roomName) {
		return Room.searchRoom(roomList, roomName);
	}
	
	public ArrayList<RoomBooking> searchBooking(LocalDate date){
		return RoomBooking.getRoomBookingByDate(bookingList, date);
	}
	
	public ArrayList<RoomBooking> searchBooking(LocalDate date, Room room){
		return RoomBooking.getRoomBooking(bookingList, date, room);
	}
	
	
	public ArrayList<RoomBooking> getRoomBookingByMonth(LocalDate monthDate){
		return RoomBooking.getRoomBookingByMonth(bookingList, monthDate);
	}
	
	public ArrayList<RoomBooking> getRoomBookingByDate(LocalDate date){
		return RoomBooking.getRoomBookingByDate(bookingList, date);
	}
	
	public ArrayList<RoomBooking> getRoomBookingByEmployeeAndDate(Employee emp, LocalDate date){
		return RoomBooking.getRoomBookingByEmployeeAndDate(bookingList, emp, date);
	} 
	
	public ArrayList<RoomBooking> getRoomBookingBySessionAndDate(LocalDate date){
		return RoomBooking.getRoomBookingByEmployeeAndDate(bookingList, session.getEmployee(), date);
	}
	
	public ArrayList<RoomBooking> getRoomBookingByEmployee(Employee employee){
		return RoomBooking.getRoomBookingByEmployee(bookingList, employee);
	}
	
	public ArrayList<RoomBooking> getRoomBookingByRoomName(String roomName){
		return RoomBooking.getRoomBookingByRoomName(bookingList, roomName);
	}
	
	public ArrayList<RoomBooking> getRoomBookingByRoomNameAndMonth(String roomName, LocalDate date){
		ArrayList<RoomBooking> rbs = RoomBooking.getRoomBookingByRoomName(bookingList, roomName);
		return RoomBooking.getRoomBookingByMonth(rbs, date);
	}
	
	public void clearSession() {
		this.session = null;
	}
	
	public boolean verifyPassword(Employee employee, Employee loginEmployee) {
		return employee.getPassword().equals(loginEmployee.getPassword()) ? true : false;
	}
	
	public abstract Employee login(Employee emp);
	
}
