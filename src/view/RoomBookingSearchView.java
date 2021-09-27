package view;

import java.util.Scanner;
import java.util.Set;

public class RoomBookingSearchView extends View{
	
	private Set<String> verifyCmds;
	
	public RoomBookingSearchView(Scanner input) {
		super(input);
	}
	
	public void setVerifyCmds(Set<String> verifyCmds) {
		this.verifyCmds = verifyCmds;
	}
	
	public String[] getCommand() {
		System.out.print("Search: ");
		String[] cmd = this.input.nextLine().split(" ");
		if(!isVerifyCmd(cmd[0])) {
			System.out.println("input not vaild");
			return null;
		}
		
		return cmd;
	}
	
	public boolean isVerifyCmd(String cmdPrefix) {
		if(cmdPrefix.equals("exit"))
			return true;

		for(String cmd: this.verifyCmds) {
			if(cmd.equals(cmdPrefix))
				return true;
		}
		return false;
	}
}
