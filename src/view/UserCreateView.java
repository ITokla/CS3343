package view;

import java.util.Scanner;


public class UserCreateView extends UserManageView{
	
	public UserCreateView(Scanner input) {
		super(input);
	}
	
	public String getUsername() {
		System.out.print("Username: ");
		return input.nextLine();
	}
	
}
