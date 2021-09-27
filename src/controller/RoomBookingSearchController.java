package controller;

import java.util.LinkedHashMap;

import controller.cmd.Search;
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
		System.out.println("[date| emp | room] [date/name] [ASC|DESC (optional)]");
		while(true) {
			String[] cmd = view.getCommand();
			if(cmd == null)
				continue;
			if(cmd[0].equals("exit"))
				break;
			System.out.println(Arrays.copyOfRange(cmd, 1, cmd.length)[0]);
			map.get(cmd[0]).execute(Arrays.copyOfRange(cmd, 1, cmd.length));
		}
	}
	
	public String getDescription() {
		return "Search Booking";
	}
	
	
}
