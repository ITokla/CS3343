package factory;

import java.util.ArrayList;

import controller.admin.UserCreateController;
import model.user.Administrator;

public class AdministratorDBOFactory {
	public static ArrayList<Administrator> create(){
		ArrayList<Administrator> admins = new ArrayList<Administrator>();
		admins.add(UserCreateController.createAdministrator("admin", "admin"));
		return admins;
	}
}
