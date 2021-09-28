package view;

import java.util.Scanner;

abstract class View {
	Scanner input;
	View(Scanner input){
		this.input = input;
	}
	
	public void showMessage(String msg) {
		System.out.println(msg);
	}
	
	public boolean Confirm() {
		System.out.println("Confirm[Y/n]");
		if(input.nextLine().trim().equals("Y"))
			return true;
		return false;
	}
}
