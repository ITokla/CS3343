package view;

import java.io.Console;
import java.util.Scanner;

import util.Hash;

abstract class UserManageView extends View{
	
	public UserManageView(Scanner input) {
		super(input);
	}
	
	public String getEmployee() {
		System.out.print("Enter Employee username: ");
		String empId = input.nextLine();
		return empId;
	}
	
	public String initPassword() {
		String pwd = null;
		String pwdConfirm = "";
		Console console = System.console();
		
		do {
			// console
			if (console != null) {
				pwd = console.readPassword("Password: ").toString();
				pwdConfirm = console.readPassword("Confirm Password: ").toString();
			}else {
				// Scanner input
				System.out.println("Warning: console not found, password input may be echoed");
				System.out.print("Password: ");
				pwd = input.nextLine();
				System.out.println("Confirm password: ");
				pwdConfirm = input.nextLine();
			}
			if(!pwd.equals(pwdConfirm))
				System.out.println("Password not match, please try again");
		}while (!pwd.equals(pwdConfirm));
		
		return Hash.md5(pwd);
	}
}
