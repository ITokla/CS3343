package controller.search.cmd.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import controller.search.cmd.DateSearch;
import controller.search.cmd.RoomSearch;

public class RoomSearch_test {
	@Test
	public void execute_test1(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		RoomSearch cr = new RoomSearch();
		String[] array = {"", "", ""};
		cr.execute(array);
		assertEquals("", stream.toString());
		
	}	
	@Test
	public void execute_test2(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		RoomSearch cr = new RoomSearch();
		String[] array = {""};
		cr.execute(array);
		assertEquals("No any record found.\r\n", stream.toString());
		
	}
}
