package view;

import java.io.Console;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import model.Hash;
import model.user.Employee;

public class UserCreateView extends View{
	
	public UserCreateView(Scanner input) {
		super(input);
	}
	
	public Employee createEmployee() throws NoSuchAlgorithmException{
		System.out.print("Username: ");
		String username = input.nextLine();
		
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
		
		return new Employee(username, Hash.md5(pwd));
	}
	
}
