package controller.admin_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.admin.ReportController;
import controller.admin.UserCreateController;
import system.MCRB;
import view.CommandView;
import view.UserCreateView;

class UserCreateController_test {
	
	public ByteArrayOutputStream getOutputStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		return stream;
	}
	
	@Test
	void test_createEmployee_companyExist() {
		class testUserCreateView extends UserCreateView{
			public testUserCreateView(Scanner input) {
				super(input);
			}
			public String getUsername() {
				return "tc01";
			}
			public String getCompanyName() {
				return "cmp1";
			}
			public int selectList(ArrayList<?> list) {
				return 0;
			}
		}
		class testUserCreateController extends UserCreateController{
			public testUserCreateController(UserCreateView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();

		testUserCreateView tucv = new testUserCreateView(input);
		testUserCreateController ucc = new testUserCreateController(tucv);
		ucc.execute();
		
		boolean result = (MCRB.getInstance().searchEmployee("tc01") != null);
		assertEquals(true,result);
		
	}
	
	@Test
	void test_createEmployee_companyExist_invalidIndex() {
		class testUserCreateView extends UserCreateView{
			public testUserCreateView(Scanner input) {
				super(input);
			}
			public String getCompanyName() {
				return "cmp1";
			}
			public int selectList(ArrayList<?> list) {
				return 1;
			}
		}
		class testUserCreateController extends UserCreateController{
			public testUserCreateController(UserCreateView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();

		testUserCreateView tucv = new testUserCreateView(input);
		testUserCreateController ucc = new testUserCreateController(tucv);
		ucc.execute();
		
		assertEquals("",stream.toString());
		
	}
	
	@Test
	void test_createEmployee_companyExist_userDuplicate() {
		class testUserCreateView extends UserCreateView{
			int time = 0;
			public testUserCreateView(Scanner input) {
				super(input);
			}
			public String getUsername() {
				time++;
				if(time<2)
					return "cp1test1";
				else
					return "cp1test0";
			}
			public String getCompanyName() {
				return "cmp1";
			}
			public int selectList(ArrayList<?> list) {
				return 0;
			}
		}
		class testUserCreateController extends UserCreateController{
			public testUserCreateController(UserCreateView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();

		testUserCreateView tucv = new testUserCreateView(input);
		testUserCreateController ucc = new testUserCreateController(tucv);
		ucc.execute();
		
		assertEquals(true,stream.toString().contains("Username is already"));
		
	}

	@Test
	void test_createEmployee_companyNotExist() {
		class testUserCreateView extends UserCreateView{
			public testUserCreateView(Scanner input) {
				super(input);
			}
			public String getCompanyName() {
				return "cmp0";
			}
		}
		class testUserCreateController extends UserCreateController{
			public testUserCreateController(UserCreateView view) {
				super(view);
			}
		}
		Scanner input = new Scanner(System.in);
		ByteArrayOutputStream stream = getOutputStream();
		
		testUserCreateView tucv = new testUserCreateView(input);
		testUserCreateController ucc = new testUserCreateController(tucv);
		ucc.execute();
		
		assertEquals("Company not found\r\n",stream.toString());
		
	}
	
	@Test
	void test_generateReport_getDescription() {
		Scanner input = new Scanner(System.in);
		UserCreateView ucv = new UserCreateView(input);
		UserCreateController uc = new UserCreateController(ucv);
		String result = uc.getDescription();
		assertEquals("Create Employee", result);	
	}

}
