package view;

import java.util.Scanner;

public class CompanyManageView extends View{

	CompanyManageView(Scanner input) {
		super(input);
		// TODO Auto-generated constructor stub
	}
	
	public String getCompanyName() {
		System.out.print("Search Company Name: ");
		return input.nextLine();
	}
	
}
