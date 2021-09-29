package factory;

import java.util.ArrayList;
import java.util.Collections;

import controller.admin.UserCreateController;
import model.Company;

public class CompanyDBOFactory{
	public static ArrayList<Company> create(){
		ArrayList<Company> list = new ArrayList<>();
		Company cmp1 = new Company("cmp1");
		cmp1.addEmployee(UserCreateController.createEmployee("cp1test", "test"));
		cmp1.addEmployee(UserCreateController.createEmployee("cp1test1", "test"));
		list.add(cmp1);
		
		Company cmp2 = new Company("cmp2");
		cmp2.addEmployee(UserCreateController.createEmployee("cp2test", "test"));
		cmp2.addEmployee(UserCreateController.createEmployee("cp2test1", "test"));
		
		list.add(cmp2);
		
		Collections.sort(list);
		return list;
	}
}
