package controller.usr_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.usr.RoomBookingSearchController;
import factory.RoomBookingDBOFactory;
import system.MCRB;
import view.RoomBookingSearchView;

class RoomBookingSearchController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_RoomBookingSearch_date_noRecord() {
		class testRoomBookingSearchView extends RoomBookingSearchView{
			int time=0;
			public testRoomBookingSearchView(Scanner input) {
				super(input);
			}
			public String[] getCommand() {
				time++;
				if(time < 2)
					return "date 2021-01-01 ASC".split(" ");
				else
					return "exit".split(" ");
			}
		}
		class testRoomBookingSearchController extends RoomBookingSearchController{
			public testRoomBookingSearchController(RoomBookingSearchView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRoomBookingSearchView trbsv = new testRoomBookingSearchView(input);
		testRoomBookingSearchController trbsc = new testRoomBookingSearchController(trbsv);
		trbsc.execute();
		
		assertEquals(true,stream.toString().contains("No any record found."));	
		
	}
	
	@Test
	void test_RoomBookingSearch_date_haveRecord() {
		class testRoomBookingSearchView extends RoomBookingSearchView{
			int time=0;
			public testRoomBookingSearchView(Scanner input) {
				super(input);
			}
			public String[] getCommand() {
				time++;
				if(time < 2)
					return "date 2022-01-01 ASC".split(" ");
				else
					return "exit".split(" ");
			}
		}
		class testRoomBookingSearchController extends RoomBookingSearchController{
			public testRoomBookingSearchController(RoomBookingSearchView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRoomBookingSearchView trbsv = new testRoomBookingSearchView(input);
		testRoomBookingSearchController trbsc = new testRoomBookingSearchController(trbsv);
		trbsc.execute();
		
		assertEquals(false,stream.toString().contains("No any record found."));	
		
	}
	
	@Test
	void test_RoomBookingSearch_name_noRecord() {
		class testRoomBookingSearchView extends RoomBookingSearchView{
			int time=0;
			public testRoomBookingSearchView(Scanner input) {
				super(input);
			}
			public String[] getCommand() {
				time++;
				if(time < 2)
					return "emp cp0test  ASC".split(" ");
				else
					return "exit".split(" ");
			}
		}
		class testRoomBookingSearchController extends RoomBookingSearchController{
			public testRoomBookingSearchController(RoomBookingSearchView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRoomBookingSearchView trbsv = new testRoomBookingSearchView(input);
		testRoomBookingSearchController trbsc = new testRoomBookingSearchController(trbsv);
		trbsc.execute();
		
		String result = stream.toString();
		
		assertEquals(false,stream.toString().contains("No any record found."));	
		
	}
	
	@Test
	void test_RoomBookingSearch_name_haveRecord() {
		class testRoomBookingSearchView extends RoomBookingSearchView{
			int time=0;
			public testRoomBookingSearchView(Scanner input) {
				super(input);
			}
			public String[] getCommand() {
				time++;
				if(time < 2)
					return "emp cp3test  ASC".split(" ");
				else
					return "exit".split(" ");
			}
		}
		class testRoomBookingSearchController extends RoomBookingSearchController{
			public testRoomBookingSearchController(RoomBookingSearchView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRoomBookingSearchView trbsv = new testRoomBookingSearchView(input);
		testRoomBookingSearchController trbsc = new testRoomBookingSearchController(trbsv);
		trbsc.execute();
		
		assertEquals(false,stream.toString().contains("No any record found."));	
		
	}
	
	@Test
	void test_RoomBookingSearch_nullCmd() {
		class testRoomBookingSearchView extends RoomBookingSearchView{
			int time=0;
			public testRoomBookingSearchView(Scanner input) {
				super(input);
			}
			public String[] getCommand() {
				time++;
				if(time < 2)
					return null;
				else
					return "exit".split(" ");
			}
		}
		class testRoomBookingSearchController extends RoomBookingSearchController{
			public testRoomBookingSearchController(RoomBookingSearchView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRoomBookingSearchView trbsv = new testRoomBookingSearchView(input);
		testRoomBookingSearchController trbsc = new testRoomBookingSearchController(trbsv);
		trbsc.execute();
		
		assertEquals(false,stream.toString().contains("No any record found."));	
		
	}
	
	@Test
	void test_RoomBookingSearch_getDesc() {
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		RoomBookingSearchView trbsv = new RoomBookingSearchView(input);
		RoomBookingSearchController trbsc = new RoomBookingSearchController(trbsv);
		String result = trbsc.getDescription();
		
		assertEquals("Search Booking",result);	
		
	}

}
