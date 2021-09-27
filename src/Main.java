
import java.util.Scanner;

public class Main {
	
	private static Scanner input;
	private static CommandHandler ch;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		ch = new CommandHandler(input);
		while(true)
			ch.execute();
	}
	
}
