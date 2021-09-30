package factory;

import java.util.LinkedHashMap;

import controller.search.cmd.DateSearch;
import controller.search.cmd.EmployeeSearch;
import controller.search.cmd.RoomSearch;
import controller.search.cmd.Search;

public class SearchCmdFactory {
	
	public static LinkedHashMap<String, Search> create(){
		LinkedHashMap<String, Search> map = new LinkedHashMap<String, Search>();
		map.put("date", new DateSearch());
		map.put("emp", new EmployeeSearch());
		map.put("room", new RoomSearch());
		return map;
	}
}
