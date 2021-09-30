package model.user.permission;

import java.util.HashMap;

public abstract class Permission {
	
	protected HashMap<String, Boolean> map;
	
	Permission(){
		map = new HashMap<String, Boolean>();
	}
	
	public HashMap<String, Boolean> getMap(){
		return map;
	}
	
}
