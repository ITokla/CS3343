package view;

import java.util.Scanner;

public class UserRemoveView extends View{
	
	protected Scanner input;
	
	public UserRemoveView(Scanner input) {
		super(input);
	}
	
	public String getEmployeeId() {
		System.out.print("Enter Employee ID: ");
		String empId = input.nextLine();
		return empId;
	}
	
	
}
