package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class CommandView extends View{
	
	protected ArrayList<String> verifyCmds;
	
	public CommandView(Scanner input) {
		super(input);
	}
	
	public void setVerifyCmds(Set<String> verifyCmds) {
		this.verifyCmds = new ArrayList<>(verifyCmds);
		this.verifyCmds.add("exit");
	}
	
	public void addVerifyCmds(String cmd) {
		this.verifyCmds.add(cmd);
	}
	
	public String[] getCommand() {
		System.out.print("\nSearch: ");
		String[] cmd = this.input.nextLine().split(" ");
		if(!isVerifyCmd(cmd[0])) {
			System.out.println("input not vaild");
			return null;
		}
		
		return cmd;
	}
	
	public boolean isVerifyCmd(String cmdPrefix) {

		for(String cmd: this.verifyCmds) {
			if(cmd.equals(cmdPrefix))
				return true;
		}
		return false;
	}
}
