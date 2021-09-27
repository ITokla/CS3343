
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import controller.Controller;
import controller.LoginController;

import java.util.Scanner;

import factory.MenuFactory;
import logging.StateManager;
import system.CRB;
import view.LoginView;


class CommandHandler{
	
	private LinkedHashMap<String, Controller> mapCmds;
	private Scanner input;
	private StateManager state;
	
	public CommandHandler(Scanner input) {
		mapCmds = new LinkedHashMap<String, Controller>();
		state = new StateManager();
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
			System.out.println(mapCmd.getKey() + "=" + mapCmd.getValue().getDescription());
			
	}
	
	public void execute() {
		
		while(true) {
			
			while (CRB.getInstance().getSession() == null) 
				mapCmds.get("login").execute();
			
			mapCmds = MenuFactory.create(input);
			
			while(CRB.getInstance().getSession() != null) {
				System.out.println();
				displayMenu();
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
