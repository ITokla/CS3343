package controller.admin_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.LoginController;
import controller.admin.ExtraCreditController;
import controller.admin.ReportController;
import model.user.Administrator;
import model.user.Employee;
import system.MCRB;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import view.CommandView;
import view.ExtraCreditView;
import view.LoginView;

class ReportController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_generateReport_admin_Valid() { //Admin use report function with valid command
		class testCommandView extends CommandView{
			public testCommandView(Scanner input) {
				super(input);
			}
			public String[] getCommand() {
				String[] input = "room rm601 2021-11".split(" ");
				return input;
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Administrator("admin", "admin");
			}			
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}	
			public Employee login(Employee emp) {
				emp.setInit(false);
				return emp;
			}			
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testCommandView tcv = new testCommandView(input);
		ReportController rc = new ReportController(tcv);
		rc.execute();
		assertEquals(false,stream.toString().contains("Invaild command."));
	}
	
	@Test
	void test_generateReport_admin_Invalid() { //Admin use report function with invalid command
		class testCommandView extends CommandView{
			public testCommandView(Scanner input) {
				super(input);
			}
			public String[] getCommand() {
				String[] input = "aiueo rm601 2021-11".split(" ");
				return input;
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Administrator("admin", "admin");
			}			
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}	
			public Employee login(Employee emp) {
				emp.setInit(false);
				return emp;
			}			
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testCommandView tcv = new testCommandView(input);
		ReportController rc = new ReportController(tcv);
		rc.execute();
		assertEquals(true,stream.toString().contains("Invaild command."));
	}
	
	@Test
	void test_generateReport_admin_Empty() { //Admin use report function with empty command
		class testCommandView extends CommandView{
			public testCommandView(Scanner input) {
				super(input);
			}
			public String[] getCommand() {
				return null;
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Administrator("admin", "admin");
			}			
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}	
			public Employee login(Employee emp) {
				emp.setInit(false);
				return emp;
			}			
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testCommandView tcv = new testCommandView(input);
		ReportController rc = new ReportController(tcv);
		rc.execute();
		assertEquals(true,stream.toString().contains("Invaild command."));
	}
	
	@Test
	void test_generateReport_employee() { //normal employee use report function
		
		class testCommandView extends CommandView{
			public testCommandView(Scanner input) {
				super(input);
			}
			public String[] getCommand() {
				String[] input = "room rm601 2021-11".split(" ");
				return input;
			}
		}
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}			
		}
		class testLoginController extends LoginController{
			public testLoginController(LoginView view) {
				super(view);
			}	
			public Employee login(Employee emp) {
				emp.setInit(false);
				return emp;
			}			
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testLoginView tlv = new testLoginView(input);
		testLoginController tlc = new testLoginController(tlv);
		tlc.execute();
		
		testCommandView tcv = new testCommandView(input);
		ReportController rc = new ReportController(tcv);
		rc.execute();
		assertNotEquals("command not found\r\n", stream.toString());
	}

	@Test
	void test_generateReport_getDescription() {
		Scanner input = new Scanner(System.in);
		CommandView cv = new CommandView(input);
		ReportController rc = new ReportController(cv);
		String result = rc.getDescription();
		assertEquals("Report", result);	
	}
	
}
