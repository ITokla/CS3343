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
}
