package controller.admin.report.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import controller.admin.report.DateReport;
import controller.admin.report.RoomReport;

public class RoomReport_test {
	@Test
	public void execute_test1(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		RoomReport cr = new RoomReport();
		String[] array = {};
		cr.execute(array);
		assertEquals("not found.\r\n",stream.toString());
		
	}
}
