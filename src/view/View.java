package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public abstract class View extends NoInputView {

	protected Scanner input;

	View(Scanner input) {
		this.input = input;
	}

	public boolean Confirm() {
		System.out.print("Confirm[Y/n]: ");
		if (input.nextLine().trim().equals("Y"))
			return true;
		return false;
	}

	public int selectList(ArrayList<?> list) {
		int index = -1;
		do {
			try {

				IntStream.range(0, list.size()).forEach(i -> System.out.println("[" + i + "]: " + list.get(i)));
				System.out.println("[" + list.size() + "]: Exit");
				System.out.print("Please Enter the index you want to chose: ");
				index = Integer.parseInt(input.nextLine());
				if (index == list.size())
					break;

			} catch (NumberFormatException e) {
				showMessage("Please enter Integer");
			}
		} while (index < 0 || index > list.size());

		return index;
	}

}
