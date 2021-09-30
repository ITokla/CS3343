package view;

import java.util.Scanner;

public class ExtraCreditView extends CompanyManageView{
	
	public ExtraCreditView(Scanner input) {
		super(input);
		// TODO Auto-generated constructor stub
	}

	public double getCredit() {
		System.out.print("Please enter extra credit (hours): ");
		return Double.parseDouble(input.nextLine());
	}
	
}
