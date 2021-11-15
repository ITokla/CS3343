package controller.search.cmd.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import controller.LoginController;
import controller.search.cmd.EmployeeSearch;
import factory.RoomBookingDBOFactory;
import model.user.Employee;
import system.MCRB;
import util.Hash;
import view.LoginView;

public class EmployeeSearch_test {
	@Test
	public void execute_test1(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		EmployeeSearch cr = new EmployeeSearch();
		String[] array = {};
		cr.execute(array);
		assertEquals("", stream.toString());
		
	}	
	@Test
	public void execute_test2(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		EmployeeSearch cr = new EmployeeSearch();
		String[] array = {""};
		cr.execute(array);
		assertEquals("Can't read the date.\r\n", stream.toString());
		
	}
	
	@Test
	public void test_employee_haveBooking(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		EmployeeSearch cr = new EmployeeSearch();
		
		Scanner input = new Scanner(System.in);
		
		MCRB.getInstance().setRoomBookingList(RoomBookingDBOFactory.create());
		
		String[] array = {"cp3test"};
		cr.execute(array);
		assertEquals(false, stream.toString().contains("No any record found."));
		
	}
}
