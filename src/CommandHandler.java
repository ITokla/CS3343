
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import controller.Controller;
import controller.LoginController;

import java.util.Scanner;

import factory.MenuFactory;
import system.MCRB;
import view.LoginView;


class CommandHandler{
	
	private LinkedHashMap<String, Controller> mapCmds;
	private Scanner input;
	
	public CommandHandler(Scanner input) {
		mapCmds = new LinkedHashMap<String, Controller>();
		this.input = input;
		initMenu();
	}
	
	public void initMenu() {
		if(mapCmds.size() > 0)
			mapCmds.clear();
		regCmd("login", new LoginController(new LoginView(input)));
	}
	
	public void regCmd(String key, Controller cmd) {
		mapCmds.put(key, cmd);
	}
	
	public void displayMenu() {
		for (Entry<String, Controller> mapCmd: mapCmds.entrySet())
			System.out.println(mapCmd.getKey() + " = " + mapCmd.getValue().getDescription());
	}
	
	public void execute() {
		
		while(true) {
			
			while (MCRB.getInstance().getSession() == null) 
				mapCmds.get("login").execute();
			
			
			mapCmds = MenuFactory.create(MCRB.getInstance().getSession(), input);
			
			while(MCRB.getInstance().getSession() != null) {
				System.out.println();
				displayMenu();
				System.out.print("\nCommand: ");
				String cmd = input.nextLine();
				if(mapCmds.containsKey(cmd))
					mapCmds.get(cmd).execute();
				else
					System.out.println("command not found");
			}
			
			initMenu();
		}

		
	}
	
}
