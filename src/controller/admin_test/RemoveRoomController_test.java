package controller.admin_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.admin.ExtraCreditController;
import controller.admin.RemoveRoomController;
import controller.usr.RoomBookingController;
import factory.RoomBookingDBOFactory;
import model.Room;
import model.RoomBooking;
import model.user.Employee;
import system.MCRB;
import view.ExtraCreditView;
import view.RemoveRoomView;
import view.RoomBookingView;

class RemoveRoomController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_rrc_RoomNotFound() {
		class testRemoveRoomView extends RemoveRoomView{
			public testRemoveRoomView(Scanner input) {
				super(input);
			}
			public String getRoomName() {
				return "Room at the end on 2/F";
			}
		}
		class testRemoveRoomController extends RemoveRoomController{
			public testRemoveRoomController(RemoveRoomView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		testRemoveRoomView trrv = new testRemoveRoomView(input);
		testRemoveRoomController trrc = new testRemoveRoomController(trrv);
		trrc.execute();
		assertEquals("Room not found.\r\n", stream.toString());
	}
	
	@Test
	void test_rrc_RoomExisted_NotConfirm_NoBooking() {
		class testRemoveRoomView extends RemoveRoomView{
			public testRemoveRoomView(Scanner input) {
				super(input);
			}
			public String getRoomName() {
				return "607";
			}
			public boolean Confirm() {
				return false;
			}
		}
		class testRemoveRoomController extends RemoveRoomController{
			public testRemoveRoomController(RemoveRoomView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		testRemoveRoomView trrv = new testRemoveRoomView(input);
		testRemoveRoomController trrc = new testRemoveRoomController(trrv);
		trrc.execute();
		assertEquals("", stream.toString());
	}
	
	@Test
	void test_rrc_RoomExisted_Confirm_NoBooking() {
		class testRemoveRoomView extends RemoveRoomView{
			public testRemoveRoomView(Scanner input) {
				super(input);
			}
			public String getRoomName() {
				return "rm601";
			}
			public boolean Confirm() {
				return true;
			}
		}
		class testRemoveRoomController extends RemoveRoomController{
			public testRemoveRoomController(RemoveRoomView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		testRemoveRoomView trrv = new testRemoveRoomView(input);
		testRemoveRoomController trrc = new testRemoveRoomController(trrv);
		trrc.execute();
		Room deleted =  MCRB.getInstance().searchRoom("rm601");
		assertEquals(null, deleted);
	}
	
	@Test
	void test_rrc_RoomExisted_Confirm_HaveBooking() {
		class testRemoveRoomView extends RemoveRoomView{
			public testRemoveRoomView(Scanner input) {
				super(input);
			}
			public String getRoomName() {
				return "RoomHasBook";
			}
			public boolean Confirm() {
				return true;
			}
		}
		class testRemoveRoomController extends RemoveRoomController{
			public testRemoveRoomController(RemoveRoomView view) {
				super(view);
			}
		}
				
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testRemoveRoomView trrv = new testRemoveRoomView(input);
		testRemoveRoomController trrc = new testRemoveRoomController(trrv);
		trrc.execute();
		
		assertEquals(true, stream.toString().contains("Removed 5 Room Booking"));
	}
	
	@Test
	void test_rrc_getDesc() {
		Scanner input = new Scanner(System.in);

		RemoveRoomView trrv = new RemoveRoomView(input);
		RemoveRoomController trrc = new RemoveRoomController(trrv);
		String result = trrc.getDescription();
		
		assertEquals("Remove Room", result);
	}

}
