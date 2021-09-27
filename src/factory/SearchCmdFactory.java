package factory;

import java.util.LinkedHashMap;

import controller.cmd.DateSearch;
import controller.cmd.EmployeeSearch;
import controller.cmd.RoomSearch;
import controller.cmd.Search;

public class SearchCmdFactory {
	
	public static LinkedHashMap<String, Search> create(){
		LinkedHashMap<String, Search> map = new LinkedHashMap<String, Search>();
		map.put("date", new DateSearch());
		map.put("emp", new EmployeeSearch());
		map.put("room", new RoomSearch());
		return map;
	}
}
