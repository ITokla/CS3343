package controller.search.cmd.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import controller.admin.report.CompanyReport;
import controller.search.cmd.DateSearch;

public class DateSearch_test {
	@Test
	public void execute_test1(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		DateSearch cr = new DateSearch();
		String[] array = {};
		cr.execute(array);
		assertEquals("", stream.toString());
		
	}	
	@Test
	public void execute_test2(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		DateSearch cr = new DateSearch();
		String[] array = {""};
		cr.execute(array);
		assertEquals("Can't read the date.\r\n", stream.toString());
		
	}
}
