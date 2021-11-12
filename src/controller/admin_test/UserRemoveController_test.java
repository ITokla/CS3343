package controller.admin_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LoginController;
import controller.admin.ReportController;
import controller.admin.UserRemoveController;
import model.user.Employee;
import view.CommandView;
import view.LoginView;
import view.UserRemoveView;

class UserRemoveController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_userRemove_employeeExist() {
		class testUserRemoveController extends UserRemoveController{
			public testUserRemoveController(UserRemoveView view) {
				super(view);
			}
		}
		class testUserRemoveView extends UserRemoveView{
			public testUserRemoveView(Scanner input) {
				super(input);
			}
			public String getEmployee() {
				return "cp1test";
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

		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Remove user
		testUserRemoveView turv = new testUserRemoveView(input);
		testUserRemoveController turc = new testUserRemoveController(turv);
		turc.execute();
		
		//Try login
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();

		assertEquals(true,stream.toString().contains("User locked."));
		
	}
	
	@Test
	void test_userRemove_employeeNotExist() {
		class testUserRemoveController extends UserRemoveController{
			public testUserRemoveController(UserRemoveView view) {
				super(view);
			}
		}
		class testUserRemoveView extends UserRemoveView{
			public testUserRemoveView(Scanner input) {
				super(input);
			}
			public String getEmployee() {
				return "cp0";
			}
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Remove user
		testUserRemoveView turv = new testUserRemoveView(input);
		testUserRemoveController turc = new testUserRemoveController(turv);
		turc.execute();

		assertEquals(true,stream.toString().contains("Employee not found."));
		
	}
	
	@Test
	void test_userRemove_getDescription() {
		Scanner input = new Scanner(System.in);
		UserRemoveView urv = new UserRemoveView(input);
		UserRemoveController urc = new UserRemoveController(urv);
		String result = urc.getDescription();
		assertEquals("Lock User", result);	
	}
	

}
