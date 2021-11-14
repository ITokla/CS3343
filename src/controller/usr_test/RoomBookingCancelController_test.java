package controller.usr_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LoginController;
import controller.usr.RoomBookingCancelController;
import factory.RoomBookingDBOFactory;
import model.RoomBooking;
import model.user.Administrator;
import model.user.Employee;
import system.MCRB;
import util.Hash;
import view.LoginView;
import view.RoomBookingCancelView;

class RoomBookingCancelController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_RoomBookingCancel_noDate() {
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
			public LocalDate getCancelDate() throws ParseException{
				return LocalDate.of(2022, 2, 1);
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp3test", "test");
			}		
			public String initPassword() {
				return Hash.md5("test");
			}			
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		trmcc.execute();
		
		assertEquals(true,stream.toString().contains("Not record found."));	
		
	}
	
	@Test
	void test_RoomBookingCancel_1booking_invalidIndex() {
		
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
			public LocalDate getCancelDate() throws ParseException{
				return LocalDate.of(2022, 1, 1);
			}
			public int selectList(ArrayList<?> list) {
				return 999;
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp3test", "test");
			}		
			public String initPassword() {
				return Hash.md5("test");
			}			
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		trmcc.execute();
		
		assertEquals(true,stream.toString().contains("Invalid index."));	
		
	}
	
	@Test
	void test_RoomBookingCancel_1booking_validIndex() {
		
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
			public LocalDate getCancelDate() throws ParseException{
				return LocalDate.of(2022, 1, 1);
			}
			public int selectList(ArrayList<?> list) {
				return 0;
			}
			public boolean Confirm() {
				return true;
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp3test", "test");
			}		
			public String initPassword() {
				return Hash.md5("test");
			}			
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		trmcc.execute();
		
		assertEquals(true,stream.toString().contains("Invalid index."));	
		
	}
	
	@Test
	void test_RoomBookingCancel_over1Booking_invalidIndex() {
		
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
			public LocalDate getCancelDate() throws ParseException{
				return LocalDate.of(2022, 1, 1);
			}
			public int selectList(ArrayList<?> list) {
				return 999;
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp3test1", "test");
			}		
			public String initPassword() {
				return Hash.md5("test");
			}			
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		trmcc.execute();
		
		assertEquals(true,stream.toString().contains("Invalid index."));	
		
	}
	
	@Test
	void test_RoomBookingCancel_over1Booking_validIndex() {
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
			public LocalDate getCancelDate() throws ParseException{
				return LocalDate.of(2022, 1, 1);
			}
			public int selectList(ArrayList<?> list) {
				return 0;
			}
			public boolean Confirm() {
				return true;
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp3test1", "test");
			}		
			public String initPassword() {
				return Hash.md5("test");
			}
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		trmcc.execute();
		
		assertEquals(true,stream.toString().contains("Room booking cancel"));	
		
	}
	
	@Test
	void test_RoomBookingCancel_over1Booking_validIndex_exit() {
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
			public LocalDate getCancelDate() throws ParseException{
				return LocalDate.of(2022, 1, 1);
			}
			public int selectList(ArrayList<?> list) {
				return 0;
			}
			public boolean Confirm() {
				return false;
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp3test1", "test");
			}			
			public String initPassword() {
				return Hash.md5("test");
			}
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		trmcc.execute();
		
		assertEquals(false,stream.toString().contains("Room booking cancel"));	
		
	}

	@Test
	void test_admin_searchRoomList() {
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Administrator("admin", "admin");
			}			
			public String initPassword() {
				return Hash.md5("admin");
			}
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		boolean result = (trmcc.searchRoomBooking(LocalDate.of(2022, 1, 1)).size() >= 3);
		
		assertEquals(true,result);	
		
	}
	
	@Test
	void test_admin_searchRoomList_notFound() {
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Administrator("admin", "admin");
			}			
			public String initPassword() {
				return Hash.md5("admin");
			}
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		ArrayList<RoomBooking> result = trmcc.searchRoomBooking(LocalDate.of(2010, 1, 1));
		
		assertEquals(null,result);	
		
	}
	
	@Test
	void test_admin_searchRoomList_beforeDate() {
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Administrator("admin", "admin");
			}			
			public String initPassword() {
				return Hash.md5("admin");
			}
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		ArrayList<RoomBooking> result = trmcc.searchRoomBooking(LocalDate.of(2000, 1, 1));
		
		assertEquals(0,result.size());	
		
	}
	
	@Test
	void test_admin_searchRoomList_getDesc() {
		class testRoomBookingCancelController extends RoomBookingCancelController{
			public testRoomBookingCancelController(RoomBookingCancelView view) {
				super(view);
			}
		}
		class testRoomBookingCancelView extends RoomBookingCancelView{
			public testRoomBookingCancelView(Scanner input) {
				super(input);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();

		testRoomBookingCancelView trmcv = new testRoomBookingCancelView(input);
		testRoomBookingCancelController trmcc = new testRoomBookingCancelController(trmcv);
		String result = trmcc.getDescription();
		
		assertEquals("Cancel Booking",result);	
		
	}
	
	
}
