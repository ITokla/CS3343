package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public abstract class View {
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
	
	public static void showAllRecords(ArrayList<?> list) {
		if(list.size() < 1) {
			System.out.println("No any record found.");
			return;
		}
		
		list.stream().forEach(System.out::println);
	}
	
	public int selectList(ArrayList<?> list) {
		int index = -1;
		try {
			do {
				IntStream.range(0, list.size())
							.forEach(i -> System.out.println("[" + i + "]: " + list.get(i)));
				System.out.println("[" + list.size() +"]: Exit");
				System.out.print("Please Enter the index you want to chose: ");
				index = Integer.parseInt(input.nextLine());
				if(index == list.size())
					break;
			}while(index < 0 || index > list.size());
		}catch(NumberFormatException e){
			showMessage("Please enter Integer");
		}
		
		return index;
	}
	
}
