package controller.usr_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LoginController;
import controller.usr.ReviewOwnBooking;
import factory.RoomBookingDBOFactory;
import model.user.Employee;
import system.MCRB;
import util.Hash;
import view.LoginView;
import view.ReviewOwnBookingView;

class ReviewOwnBooking_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_ReviewOwningBooking_noRecord() {
		
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
		
		//Login with cp1test
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();
		
		ReviewOwnBookingView rowbv = new ReviewOwnBookingView(input);
		ReviewOwnBooking robc = new ReviewOwnBooking(rowbv);
		robc.execute();
		
		assertEquals(true,stream.toString().contains("No any records"));		
		
	}
	
	@Test
	void test_ReviewOwningBooking_haveRecord() {
		
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
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Login with cp1test
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();
		
		ReviewOwnBookingView rowbv = new ReviewOwnBookingView(input);
		ReviewOwnBooking robc = new ReviewOwnBooking(rowbv);
		robc.execute();
		
		assertEquals(false,stream.toString().contains("No any records"));		
		
	}
	
	@Test
	void test_ReviewOwningBooking_getDesc() {
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		ReviewOwnBookingView rowbv = new ReviewOwnBookingView(input);
		ReviewOwnBooking robc = new ReviewOwnBooking(rowbv);
		String result = robc.getDescription();
		
		assertEquals("Review Own Booking",result);		
		
	}
	
	

}
