package controller_test;

import java.util.Scanner;

import org.junit.Test;

import controller.LoginController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static java.lang.System.*;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.PrintStream;

import model.user.Administrator;
import model.user.Employee;
import util.Hash;
import view.LoginView;
import view.LogoutView;

public class LoginController_test{
	
	@Test
	public void admin_login_test(){
		Administrator test_em =  new Administrator("admin", "admin");
		Administrator em = test_em;
		
		Scanner input = new Scanner(System.in);
		LoginView v = new LoginView(input);
		LoginController lc = new LoginController(v);
		
		test_em = (Administrator) lc.login(test_em);
		assertNotEquals(test_em, em);
	}
	
	@Test
	public void Employee_login_test(){
		Employee test_em =  new Administrator("admin", "admin");
		Employee em = test_em;
		
		Scanner input = new Scanner(System.in);
		LoginView v = new LoginView(input);
		LoginController lc = new LoginController(v);
		
		test_em = (Employee) lc.login(test_em);
		assertNotEquals(test_em, em);
	}
	
	@Test
	public void execute_test1(){// emp = null
		class LoginView2 extends LoginView{

			public LoginView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			
			public Employee getLoginUser() {
				return null;
			}
			
		}
		class LoginController2 extends LoginController{

			public LoginController2(LoginView2 view) {
				super(view);
			}
			
			public Employee login(Employee emp) {
				return null;
			}
			
		}
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		
		Scanner input = new Scanner(System.in);
		LoginView2 v = new LoginView2(input);
		LoginController2 lc2 = new LoginController2(v);
		lc2.execute();
		assertEquals("Username or Password incorrect\r\n", stream.toString());
		
	}
	
	@Test 
	public void execute_test2(){
		class LoginView2 extends LoginView{

			public LoginView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}
			
		}
		class LoginController2 extends LoginController{

			public LoginController2(LoginView2 view) {
				super(view);
			}
			
			public Employee login(Employee emp) {
				emp.setStatus(2);
				return emp;
			}
			
		}	
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		
		Scanner input = new Scanner(System.in);
		LoginView2 v = new LoginView2(input);
		LoginController2 lc2 = new LoginController2(v);
		lc2.execute();
		assertEquals("User locked.\r\n", stream.toString());
	}
	
	@Test 
	public void execute_test3(){
		class LoginView2 extends LoginView{

			public LoginView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}
			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}
			
		}
		class LoginController2 extends LoginController{

			public LoginController2(LoginView2 view) {
				super(view);
			}
			
			public Employee login(Employee emp) {
				emp.setInit(false);
				return emp;
			}
			
		}	
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		
		Scanner input = new Scanner(System.in);
		LoginView2 v = new LoginView2(input);
		LoginController2 lc2 = new LoginController2(v);
		lc2.execute();
		assertEquals("Login successful\r\n", stream.toString());
	}
	
	@Test 
	public void execute_test4(){
		class LoginView2 extends LoginView{

			public LoginView2(Scanner input) {
				super(input);
			}
			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}
			
			public String initPassword() {
				return "123456";
			}
			
		}
		class LoginController2 extends LoginController{

			public LoginController2(LoginView2 view) {
				super(view);
			}
			
			public Employee login(Employee emp) {
				emp.setInit(true);
				return emp;
			}
			
		}	
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		
		Scanner input = new Scanner(System.in);
		LoginView2 v = new LoginView2(input);
		LoginController2 lc2 = new LoginController2(v);
		lc2.execute();
		assertEquals("Login successful\r\nSetup new Password\r\n", stream.toString());
	}
	
	@Test 
	public void execute_getDesc(){
		Scanner input = new Scanner(System.in);
		LoginView v = new LoginView(input);
		LoginController lc2 = new LoginController(v);
		String result = lc2.getDescription();
		assertEquals("Login", result);
	}
	
}
