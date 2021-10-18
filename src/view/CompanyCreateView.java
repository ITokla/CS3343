package view;

import java.util.Scanner;

public class CompanyCreateView extends CompanyManageView{

	public CompanyCreateView(Scanner input) {
		super(input);
		// TODO Auto-generated constructor stub
	}
	
	public String getCreateCompanyName() {
		System.out.print("Please enter the Company name: ");
		return input.nextLine();
	}

}
