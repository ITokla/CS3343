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
	
	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
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
		ByteArrayOutputStream stream = getOutputStream();
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
		adc.execute();
		
		boolean check = false;
		if(MCRB.getInstance().searchRoom("Test2") != null) {//test1
			check = true;
		}
		assertEquals(true, check);
	}
	
	@Test
	public void test_addRoomNotExisted() {
		class testAddRoomView extends AddRoomView{
			public testAddRoomView(Scanner input) {
				super(input);
			}
			public Room createRoom() {
				return new Room("Room 01");
			}
		}
		class testAddRoomController extends AddRoomController{
						
			public testAddRoomController(AddRoomView view) {
				super(view);
			}
			
		}
		
		ByteArrayOutputStream stream = getOutputStream();
		Scanner input = new Scanner(System.in);
		testAddRoomView v = new testAddRoomView(input);
		testAddRoomController arc = new testAddRoomController(v);
		arc.execute();
		assertEquals("", stream.toString());
	
	}
	
	@Test
	public void test_addRoomExisted() {
		class testAddRoomView extends AddRoomView{
			public testAddRoomView(Scanner input) {
				super(input);
			}
			public Room createRoom() {
				return new Room("Room 02");
			}
		}
		class testAddRoomController extends AddRoomController{
						
			public testAddRoomController(AddRoomView view) {
				super(view);
			}
			
		}
		
		ByteArrayOutputStream stream = getOutputStream();
		Scanner input = new Scanner(System.in);
		testAddRoomView v1 = new testAddRoomView(input);
		testAddRoomController arc1 = new testAddRoomController(v1);
		testAddRoomView v2 = new testAddRoomView(input);
		testAddRoomController arc2 = new testAddRoomController(v2);
		arc1.execute();
		arc2.execute();
		assertEquals("Room name is already.\r\n", stream.toString());
	
	}
	
	@Test
	public void test_getDescriptions() {
		
		Scanner input = new Scanner(System.in);
		AddRoomView arv = new AddRoomView(input);
		AddRoomController arc = new AddRoomController(arv);
		String result = arc.getDescription();
		assertEquals("Add Room", result);	
		
	}
}
