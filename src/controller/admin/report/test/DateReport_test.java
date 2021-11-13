package controller.admin.report.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import controller.admin.report.CompanyReport;
import controller.admin.report.DateReport;

public class DateReport_test {
	@Test
	public void execute_test1(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		DateReport cr = new DateReport();
		String[] array = {"123"};
		cr.execute(array);
		assertEquals("Can't read the date\r\n", stream.toString());
		
	}
//	@Test
//	public void execute_test2(){//bug
//		ByteArrayOutputStream stream = new ByteArrayOutputStream();
//		PrintStream printStream = new PrintStream(stream);
//		System.setOut(printStream);
//		DateReport cr = new DateReport();
//		String[] array = {"2021-11-10"};
//		cr.execute(array);
//		assertEquals(stream.toString(), "=========Report Start========");
//		
//	}
}
