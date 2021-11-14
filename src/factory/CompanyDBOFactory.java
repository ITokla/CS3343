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

		//2021.11.14 17:29 Ryan
		Company cmp3 = new Company("cmp3");
		cmp3.addEmployee(UserCreateController.createEmployee("cp3test", "test"));
		cmp3.addEmployee(UserCreateController.createEmployee("cp3test1", "test"));
		
		list.add(cmp2);
		list.add(cmp3);
		
		Collections.sort(list);
		return list;
	}
}
