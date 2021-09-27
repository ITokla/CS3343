package system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import factory.EmployeeDBOFactory;
import factory.RoomBookingDBOFactory;
import factory.RoomDBOFactory;
import model.Employee;
import model.Room;
import model.Session;
import model.RoomBooking;

public class CRB {
	
	private final static CRB instance = new CRB();
	private static ArrayList<Employee> employeeList;
	private static ArrayList<Room> roomList;
	private static ArrayList<RoomBooking> bookingList;
	private static Session session;
	
	private CRB() {
		// employeeList = new ArrayList<>();
		employeeList = EmployeeDBOFactory.create();
		Employee emp = new Employee("test", "test");
		employeeList.add(emp);
		roomList = RoomDBOFactory.create();
		bookingList = RoomBookingDBOFactory.create(emp);
		session = null;
	}
	
	public static CRB getInstance() {
		return instance;
	}
	
	public ArrayList<Employee> getEmployeeList(){
		return employeeList;
	}
	
	public void regEmployee(Employee emp) {
		employeeList.add(emp);
	}
	
	public void addRoom(Room room) {
		roomList.add(room);
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
	
	public Employee searchEmployee(String name) {
		ArrayList<Employee> tmpEmployeeList = employeeList;
		Collections.sort(tmpEmployeeList);
		int index = Collections.binarySearch(tmpEmployeeList, new Employee(name, null));
		return (index > -1)? tmpEmployeeList.get(index): null;
	}
	
	public ArrayList<RoomBooking> getRoomBookingByRoomName(String roomName){
		return RoomBooking.getRoomBookingByRoomName(bookingList, roomName);
	}
	
	public void clearSession() {
		CRB.session = null;
	}
}
