package controller_test;

import java.util.Scanner;

import org.junit.Test;

import controller.LoginController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static java.lang.System.*;
import java.io.Console;

import model.user.Administrator;
import model.user.Employee;
import util.Hash;
import view.LoginView;

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
	public void execute_test1() { // employee != NULL && emp.getStatus() == 2
//	
//		class LoginView2 extends LoginView{
//			
//			public LoginView2(Scanner input) {
//				super(input);
//			}
//			
//			public Employee getLoginUser(){
//				return new Employee("cp1test", "test");
//			}
//			
//		}
////		Scanner input = new Scanner(System.in);
////		LoginView2 lv2 = new LoginView2(input);
////		Employee emp = lv2.getLoginUser();
////		emp.
	}
}
