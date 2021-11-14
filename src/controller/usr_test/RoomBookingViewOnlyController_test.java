package controller.usr_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.usr.RoomBookingViewOnlyController;
import factory.RoomBookingDBOFactory;
import system.MCRB;
import view.RoomBookingView;

class RoomBookingViewOnlyController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_RoomBookingViewOnly_nullDate() {
		
		class  testRoomBookingView extends RoomBookingView{
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return null;
			}
		}
		class testRoomBookingViewOnlyController extends RoomBookingViewOnlyController{
			public testRoomBookingViewOnlyController(RoomBookingView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingViewOnlyController trbc = new testRoomBookingViewOnlyController(trbv);
		trbc.execute();
		
		assertEquals(true,stream.toString().contains("Invalid Date Format."));	
				
	}
	
	@Test
	void test_RoomBookingViewOnly_allAble() {
		
		class  testRoomBookingView extends RoomBookingView{
			public testRoomBookingView(Scanner input) {
				super(input);
			}
			public LocalDate getDate() throws NumberFormatException{
				return LocalDate.of(2022, 2, 2);
			}
		}
		class testRoomBookingViewOnlyController extends RoomBookingViewOnlyController{
			public testRoomBookingViewOnlyController(RoomBookingView view) {
				super(view);
			}
		}
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRoomBookingView trbv = new testRoomBookingView(input);
		testRoomBookingViewOnlyController trbc = new testRoomBookingViewOnlyController(trbv);
		trbc.execute();
		
		assertEquals(true,stream.toString().contains("RoomHasBook"));	
				
	}
	
	@Test
	void test_RoomBookingViewOnly_getDesc() {
				
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		RoomBookingView trbv = new RoomBookingView(input);
		RoomBookingViewOnlyController trbc = new RoomBookingViewOnlyController(trbv);
		String result = trbc.getDescription();
		
		assertEquals("View Room Available",result);	
				
	}

}
