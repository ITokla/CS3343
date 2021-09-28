package factory;

import java.util.ArrayList;
import controller.UserCreateController;
import model.user.Employee;

public class EmployeeDBOFactory {
	public static ArrayList<Employee> create(){
		ArrayList<Employee> list = new ArrayList<>();
		list.add(UserCreateController.createEmployee("test", "test"));
		list.add(UserCreateController.createAdministrator("admin", "admin"));
		return list;
	}
}
