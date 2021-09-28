package view;

import java.io.Console;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import model.user.Employee;
import util.Hash;

public class UserCreateView extends UserManageView{
	
	public UserCreateView(Scanner input) {
		super(input);
	}
	
	public String getUsername() {
		System.out.print("Username: ");
		return input.nextLine();
	}
	
	
}
