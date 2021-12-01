package view;

import java.io.Console;
import java.util.Scanner;

import model.user.Employee;

public class LoginView extends UserManageView {

	public LoginView(Scanner input) {
		super(input);
	}

	public Employee getLoginUser() {

		// Get username
		System.out.print("Username: ");
		String username = input.nextLine();

		// Get Password
		String pwd = null;
		Console console = System.console();
		if (console != null) {
			pwd = new String(System.console().readPassword("Password:"));
			System.out.println(pwd);
		}else {
			System.out.println("Warning: console not found, password input may be echoed");
			System.out.print("Password: ");
			pwd = input.nextLine();
		}
		
		return new Employee(username, pwd);

	}

}
