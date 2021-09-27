package factory;

import java.util.ArrayList;
import controller.UserCreateController;
import model.Employee;

public class EmployeeDBOFactory {
	public static ArrayList<Employee> create(){
		ArrayList<Employee> list = new ArrayList<>();
		list.add(UserCreateController.createEmployee("test", "test"));
		
		return list;
	}
}
