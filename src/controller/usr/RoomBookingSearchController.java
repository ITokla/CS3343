package controller.usr;

import java.util.LinkedHashMap;

import controller.Controller;
import controller.search.cmd.Search;
import factory.SearchCmdFactory;
import view.RoomBookingSearchView;
import java.util.Arrays;

public class RoomBookingSearchController extends Controller{
	
	private RoomBookingSearchView view;
	private LinkedHashMap<String, Search> map;
	public RoomBookingSearchController(RoomBookingSearchView view) {
		this.view = view;
		this.map = SearchCmdFactory.create();
		
		this.view.setVerifyCmds(this.map.keySet());
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		view.showMessage("[date| emp | room] [date/name] [ASC|DESC (optional)]");
		view.showMessage("Enter: exit will quit the search mode.");
		while(true) {
			String[] cmd = view.getCommand();
			if(cmd == null)
				continue;
			// exit the search
			if(cmd[0].equals("exit"))
				break;
			
			// remove command Prefix (date|emp|room) and pass the args to execute
			map.get(cmd[0]).execute(Arrays.copyOfRange(cmd, 1, cmd.length));
		}
	}
	
	public String getDescription() {
		return "Search Booking";
	}
	
	
}
