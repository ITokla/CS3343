package controller.admin_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LoginController;
import controller.admin.ReportController;
import controller.admin.UserPasswordResetController;
import model.user.Employee;
import view.CommandView;
import view.LoginView;
import view.UserPasswordResetView;

class UserPasswordResetController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_userPasswordReset_employeeExist() {
		class testUserPasswordResetController extends UserPasswordResetController{
			public testUserPasswordResetController(UserPasswordResetView view) {
				super(view);
			}
		}
		class testUserPasswordResetView extends UserPasswordResetView{
			public testUserPasswordResetView(Scanner input) {
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
		
		//Reset password
		testUserPasswordResetView tuprv = new testUserPasswordResetView(input);
		testUserPasswordResetController tuprc = new testUserPasswordResetController(tuprv);
		tuprc.execute();
		
		//Try login
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();

		assertEquals(true,stream.toString().contains("Username or Password incorrect"));
		
	}
	
	@Test
	void test_userPasswordReset_employeeNotExist() {
		class testUserPasswordResetController extends UserPasswordResetController{
			public testUserPasswordResetController(UserPasswordResetView view) {
				super(view);
			}
		}
		class testUserPasswordResetView extends UserPasswordResetView{
			public testUserPasswordResetView(Scanner input) {
				super(input);
			}
			public String getEmployee() {
				return "cp0";
			}
		}		

		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Reset password
		testUserPasswordResetView tuprv = new testUserPasswordResetView(input);
		testUserPasswordResetController tuprc = new testUserPasswordResetController(tuprv);
		tuprc.execute();

		assertEquals(true,stream.toString().contains("User not found."));
		
	}
	
	@Test
	void test_userPasswordReset_getDescription() {
		Scanner input = new Scanner(System.in);
		UserPasswordResetView uprv = new UserPasswordResetView(input);
		UserPasswordResetController uprc = new UserPasswordResetController(uprv);
		String result = uprc.getDescription();
		assertEquals("User Password Reset", result);	
	}

}
