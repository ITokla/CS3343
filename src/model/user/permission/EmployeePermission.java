package model.user.permission;

public class EmployeePermission extends Permission{
	
	private static EmployeePermission instance = new EmployeePermission();
	
	protected EmployeePermission() {
		super();
		this.map.put("rb", true);
		this.map.put("rbc", true);
		this.map.put("search", true);
		this.map.put("own", true);
		this.map.put("vra", true);
	}
	
	public static EmployeePermission getInstance() {
		return instance;
	}
}
