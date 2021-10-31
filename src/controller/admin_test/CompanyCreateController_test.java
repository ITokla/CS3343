package controller.admin_test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import controller.admin.AddRoomController;
import controller.admin.CompanyCreateController;
import model.Room;
import system.MCRB;
import view.AddRoomView;
import view.CompanyCreateView;

public class CompanyCreateController_test {
	@Test
	public void execute_test1() {
		class CompanyCreateView2 extends CompanyCreateView{

			public CompanyCreateView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			
			public String getCreateCompanyName() {
				return "cmp1";
			}
			
		}
		Scanner sc = new Scanner(System.in);
		CompanyCreateView2 view2 = new CompanyCreateView2(sc);
		CompanyCreateController adc = new CompanyCreateController(view2);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		adc.execute();
		
		assertEquals("Company Name duplicated\r\n", stream.toString());
	}
	
	@Test
	public void execute_test2() {
		class CompanyCreateView2 extends CompanyCreateView{

			public CompanyCreateView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			
			public String getCreateCompanyName() {
				return "Test";
			}
			
		}
		Scanner sc = new Scanner(System.in);
		CompanyCreateView2 view2 = new CompanyCreateView2(sc);
		CompanyCreateController adc = new CompanyCreateController(view2);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		adc.execute();
		
		assertEquals("Test is created.\r\n", stream.toString());
	}
}
