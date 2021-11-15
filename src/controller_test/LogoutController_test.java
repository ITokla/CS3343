package controller_test;

import static org.junit.Assert.assertEquals;
import java.util.Scanner;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import controller.LogoutController;
import view.LogoutView;


public class LogoutController_test {

	@Test
	public void execute_test1() {
		//System print part
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		
		Scanner input = new Scanner(System.in);
		LogoutView v = new LogoutView(input);
		LogoutController lc = new LogoutController(v);	
		lc.execute();
		
		assertEquals("Logouted\r\n", stream.toString());
	}
	
	@Test
	public void execute_getDesc() {
		Scanner input = new Scanner(System.in);
		LogoutView v = new LogoutView(input);
		LogoutController lc = new LogoutController(v);	
		String result = lc.getDescription();
		
		assertEquals("Logout", result);
	}
	
	

	

}
