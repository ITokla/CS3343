package controller.admin.report.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import controller.admin.report.CompanyReport;
import system.MCRB;

public class CompanyReport_test {
	
	@Test
	public void execute_test1(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		CompanyReport cr = new CompanyReport();
		String[] array = {};
		cr.execute(array);
		assertEquals("Can't search the Company\r\n", stream.toString());
		
	}
	
	@Test
	public void execute_test2(){
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		CompanyReport cr = new CompanyReport();
		String[] array = {"cmp3"};
		cr.execute(array);
		assertEquals("cmp3 not Found\r\n", stream.toString());
		
	}
	
//	@Test
//	public void execute_test3(){ //today and not today
//
//		ByteArrayOutputStream stream = new ByteArrayOutputStream();
//		PrintStream printStream = new PrintStream(stream);
//		System.setOut(printStream);
//		CompanyReport cr = new CompanyReport();
//		String[] array = {"cmp2"};
//		cr.execute(array);
//		assertEquals("", stream.toString());
//		
//	}
}
