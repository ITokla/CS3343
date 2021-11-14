package controller.usr_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LoginController;
import controller.admin.UserRemoveController;
import controller.usr.PasswordSetupController;
import model.user.Employee;
import system.MCRB;
import util.Hash;
import view.LoginView;
import view.UserManageView;
import view.UserRemoveView;

class PasswordSetupController_test {

	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_userPasswordSetup_userUnlock() {
		class testLoginView extends LoginView{
			public testLoginView(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp1test", "test");
			}			
			public String initPassword() {
				return Hash.md5("abc");
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
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		//Remove user
		testUserRemoveView turv = new testUserRemoveView(input);
		UserRemoveController turc = new UserRemoveController(turv);
		turc.execute();
		
		//Unlock User
		Employee testemp = MCRB.getInstance().searchEmployee("cp1test");
		PasswordSetupController.initPassowrd(testemp);
		
		//Try login
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();
		
		assertEquals(true,stream.toString().contains("Setup new Password"));
		
	}
	
	@Test
	void test_userPasswordSetup_setPassword() {
		class testPasswordSetupController extends PasswordSetupController{
			public testPasswordSetupController(UserManageView view) {
				super(view);
			}
		}
		class testUserManageView extends UserManageView{
			public testUserManageView(Scanner input) {
				super(input);
			}
			public String initPassword() {
				return Hash.md5("abc");
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
		class testLoginView2 extends LoginView{
			public testLoginView2(Scanner input) {
				super(input);
				// TODO Auto-generated constructor stub
			}			
			public Employee getLoginUser() {
				return new Employee("cp1test", "abc");
			}
		}
		
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();

		//Login using pwd "test"
		testLoginView tlv = new testLoginView(input);
		LoginController tlc = new LoginController(tlv);
		tlc.execute();
		
		//Setup pwd
		testUserManageView tumv = new testUserManageView(input);
		testPasswordSetupController tpsc = new testPasswordSetupController(tumv);
		tpsc.execute();
		
		//Login using pwd "test2"
		testLoginView2 tlv2 = new testLoginView2(input);
		tlc = new LoginController(tlv2);
		tlc.execute();
		
		assertEquals(true,stream.toString().contains("Login successful"));
		
	}

}
