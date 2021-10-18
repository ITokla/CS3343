package model.user.permission;

public class AdministratorPermission extends EmployeePermission{
	
	private static AdministratorPermission instance = new AdministratorPermission();
	
	protected AdministratorPermission() {
		super();
		this.map.put("ur", true);
		this.map.put("uc", true);
		this.map.put("rr", true);
		this.map.put("ar", true);
		this.map.put("upwdrest", true);
		this.map.put("rep", true);
		this.map.put("credit", true);
		this.map.put("rb", false);
		this.map.put("own", false);
		this.map.put("cc", true);
		this.map.put("cr",true);
	}
	
	public static AdministratorPermission getInstance() {
		return instance;
	}
	
}
