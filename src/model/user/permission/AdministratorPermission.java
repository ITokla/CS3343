package model.user.permission;

public class AdministratorPermission extends EmployeePermission{
	
	private static AdministratorPermission instance = new AdministratorPermission();
	
	protected AdministratorPermission() {
		super();
		this.map.put("ur", true);
		this.map.put("uc", true);
		this.map.put("rr", true);
		this.map.put("ar", true);
	}
	
	public static AdministratorPermission getInstance() {
		return instance;
	}
	
}
