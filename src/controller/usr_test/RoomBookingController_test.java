package controller.usr_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LoginController;
import controller.usr.RoomBookingController;
import factory.RoomDBOFactory;
import model.user.Employee;
import system.MCRB;
import util.Hash;
import view.LoginView;
import view.RoomBookingView;

class RoomBookingController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_RoomBooking_NullDate() {
		class testRoomBookingView extends RoomBookingView{
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return null;
			}
		}
		class testRoomBookingController extends RoomBookingController{
			public testRoomBookingController(RoomBookingView view) {
				super(view);
			}
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingController trbc = new testRoomBookingController(trbv);
		trbc.execute();
		
		assertEquals(true,stream.toString().contains("Date must be >= now."));	
		
	}
	
	@Test
	void test_RoomBooking_BeforeDate() {
		class testRoomBookingView extends RoomBookingView{
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return LocalDate.of(1990, 1, 1);
			}
		}
		class testRoomBookingController extends RoomBookingController{
			public testRoomBookingController(RoomBookingView view) {
				super(view);
			}
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingController trbc = new testRoomBookingController(trbv);
		trbc.execute();
		
		assertEquals(true,stream.toString().contains("Date must be >= now."));	

	}
	
	@Test
	void test_RoomBooking_0Room() {
		class testRoomBookingView extends RoomBookingView{
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return LocalDate.of(2022,01,01);
			}
		}
		class testRoomBookingController extends RoomBookingController{
			public testRoomBookingController(RoomBookingView view) {
				super(view);
			}
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Clean Rooms
		MCRB.getInstance().cleanRoom();
		
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingController trbc = new testRoomBookingController(trbv);
		trbc.execute();
		
		assertEquals(true,stream.toString().contains("No any room avaiable."));	
		
	}
	
	@Test
	void test_RoomBooking_invalidRoom() {
		class testRoomBookingView extends RoomBookingView{
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return LocalDate.of(2022,01,01);
			}
			public String getRoomName() {
				return "rm000";
			}
		}
		class testRoomBookingController extends RoomBookingController{
			public testRoomBookingController(RoomBookingView view) {
				super(view);
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}		
			public String initPassword() {
				return Hash.md5("test");
			}			
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
				
		//Login
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();
		
		//Make Booking
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingController trbc = new testRoomBookingController(trbv);
		trbc.execute();
		
		assertEquals(true,stream.toString().contains("Room not found"));	
		
	}
	
	@Test
	void test_RoomBooking_invalidStartTime() {
		class testRoomBookingView extends RoomBookingView{
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return LocalDate.of(2022,01,01);
			}
			public String getRoomName() {
				return "sss606";
			}
			public int selectList(ArrayList<?> list) {
				return 100;
			}
		}
		class testRoomBookingController extends RoomBookingController{
			public testRoomBookingController(RoomBookingView view) {
				super(view);
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}		
			public String initPassword() {
				return Hash.md5("test");
			}			
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
				
		//Login
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();
		
		//Make Booking
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingController trbc = new testRoomBookingController(trbv);
		trbc.execute();
		
		assertEquals(true,stream.toString().contains("Invalid Start Time"));	
		
	}
	
	@Test
	void test_RoomBooking_invalidEndTime() {
		class testRoomBookingView extends RoomBookingView{
			int time=0;
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return LocalDate.of(2022,01,01);
			}
			public String getRoomName() {
				return "sss606";
			}
			public int selectList(ArrayList<?> list) {
				time++;
				if(time == 1)
					return 0;
				else return 100;
			}
		}
		class testRoomBookingController extends RoomBookingController{
			public testRoomBookingController(RoomBookingView view) {
				super(view);
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}		
			public String initPassword() {
				return Hash.md5("test");
			}			
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Clean Rooms
		MCRB.getInstance().setRoomList(RoomDBOFactory.create());
		
		//Login
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();
		
		//Make Booking
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingController trbc = new testRoomBookingController(trbv);
		trbc.execute();
		
		assertEquals(true,stream.toString().contains("Invalid End Time"));	
		
	}
	
	@Test
	void test_RoomBooking_validEndTime() {
		class testRoomBookingView extends RoomBookingView{
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return LocalDate.of(2022,01,01);
			}
			public String getRoomName() {
				return "sss606";
			}
			public int selectList(ArrayList<?> list) {
				return 0;
			}
		}
		class testRoomBookingController extends RoomBookingController{
			public testRoomBookingController(RoomBookingView view) {
				super(view);
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}	
			public String initPassword() {
				return Hash.md5("test");
			}
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Clean Rooms
		MCRB.getInstance().setRoomList(RoomDBOFactory.create());
		
		//Login
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();
		
		//Make Booking
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingController trbc = new testRoomBookingController(trbv);
		trbc.execute();
		
		assertEquals(false,stream.toString().contains("Invalid End Time"));	
		
	}
	
	@Test
	void test_RoomBooking_noCredit() {
		class testRoomBookingView extends RoomBookingView{
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return LocalDate.of(2022,01,01);
			}
			public String getRoomName() {
				return "sss606";
			}
			public int selectList(ArrayList<?> list) {
				return 0;
			}
		}
		class testRoomBookingController extends RoomBookingController{
			public testRoomBookingController(RoomBookingView view) {
				super(view);
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}			
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
				
		//Login
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();
		
		//Make Booking
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingController trbc = new testRoomBookingController(trbv);
		trbc.execute();
		trbc.execute();
		
		assertEquals(true,stream.toString().contains("Credit insufficient."));	
		
	}

	
}
