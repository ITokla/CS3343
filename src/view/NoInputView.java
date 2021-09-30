package view;

import java.util.ArrayList;

public abstract class NoInputView {
	
	public static void showAllRecords(ArrayList<?> list) {
		if(list.size() < 1) {
			System.out.println("No any record found.");
			return;
		}
		
		list.stream().forEach(System.out::println);
	}
	
	public void showMessage(String msg) {
		System.out.println(msg);
	}
}
