package controller.admin_test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import controller.admin.AddRoomController;
import model.Room;
import system.MCRB;
import view.AddRoomView;

public class AddRoomController_test {
	
	@Test
	public void execute_test1() {
		class AddRoomView2 extends AddRoomView{

			public AddRoomView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			
			public Room createRoom() {
				return new Room("602");
			}
			
		}
		Scanner sc = new Scanner(System.in);
		AddRoomView2 view2 = new AddRoomView2(sc);
		AddRoomController adc = new AddRoomController(view2);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		adc.execute();
		
		assertEquals("Room name is already.\r\n", stream.toString());
	}
	
	@Test
	public void execute_test2() {
		class AddRoomView2 extends AddRoomView{

			public AddRoomView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			
			public Room createRoom() {
				return new Room("Test2");
			}
			
		}
		Scanner sc = new Scanner(System.in);
		AddRoomView2 view2 = new AddRoomView2(sc);
		AddRoomController adc = new AddRoomController(view2);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		adc.execute();
		
		boolean check = false;
		if(MCRB.getInstance().searchRoom("Test2") != null) {//test1
			check = true;
		}
		assertEquals(true, check);
	}
}
