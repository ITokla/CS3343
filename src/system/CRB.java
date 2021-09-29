package system;

import java.util.ArrayList;
import java.util.Collections;

import factory.EmployeeDBOFactory;
import factory.RoomDBOFactory;
import model.user.Employee;


public class CRB extends CRBCore{
	
	private final static CRB instance = new CRB();
	private ArrayList<Employee> employeeList;
	
	private CRB() {
		super(RoomDBOFactory.create());
		employeeList = EmployeeDBOFactory.create();
	}
	
	public static CRB getInstance() {
		return instance;
	}
	
	public ArrayList<Employee> getEmployeeList(){
		return employeeList;
	}
	
	public void regEmployee(Employee emp) {
		employeeList.add(emp);
		Collections.sort(employeeList);
	}
	
	public Employee searchEmployee(String name) {
		int index = Collections.binarySearch(employeeList, new Employee(name, null));
		return (index > -1)? employeeList.get(index): null;
	}
	
	public void removeEmployee(Employee emp) {
		employeeList.remove(emp);
	}
	
	public Employee login(Employee emp) {
		Employee employee = searchEmployee(emp.getUsername());
		boolean login = (employee != null && verifyPassword(employee, emp));
		if(login)
			createSession(employee);
		return (!login)? null: employee;
	}
	
}
