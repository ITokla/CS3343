package system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import factory.CompanyDBOFactory;
import factory.RoomDBOFactory;
import model.Company;
import model.RoomBooking;
import model.user.Administrator;
import model.user.Employee;

public class MCRB extends CRBCore{
	
	// Adapter
	private final static MCRB instance = new MCRB();
	private ArrayList<Company> companyList;
	private ArrayList<Administrator> admins;
	
	private MCRB() {
		super(RoomDBOFactory.create());
		companyList = CompanyDBOFactory.create();
		admins = new ArrayList<Administrator>();
	}
	
	public static MCRB getInstance() {
		return instance;
	}
	
	public void addCompany(Company company) {
		companyList.add(company);
		Collections.sort(companyList);
	}
	
	public ArrayList<Employee> getEmployeeList(String companyName) {
		int index = Collections.binarySearch(companyList, new Company(companyName));
		return (index < 0)? null : companyList.get(index).getEmployees();
	}
	
	public Employee login(Employee emp) {
		for(Company cmp: companyList) {
			ArrayList<Employee> cmpEMPList = cmp.getEmployees();
			Collections.sort(cmpEMPList);
			int index = Collections.binarySearch(cmpEMPList, emp);
			if(index > -1) 
				return (this.verifyPassword(cmpEMPList.get(index), emp))?
						cmpEMPList.get(index): null;
		}
		return null;
	}
	
	public Company getCompany(String companyName) {
		int index = Collections.binarySearch(companyList, new Company(companyName));
		return (index < 0)? null: companyList.get(index);
	}
	
	public ArrayList<Company> searchCompany(String companyName) {
	 	return new ArrayList<Company>(companyList.stream()
				.filter( s -> s.getName().contains(companyName))
				.collect(Collectors.toList()));
	}
	
	public Company searchCompany(Employee emp) {
		for(Company cmp: companyList) {
			int index = Collections.binarySearch(cmp.getEmployees(), emp);
			if(index > -1) 
				return cmp;
		}
		return null;
	}
	
	public Employee searchEmployee(String username) {
		Employee emp = null;
		for (Company cmp: companyList) {
			Employee result = Employee.search(cmp.getEmployees(), username);
			if(emp != null) {
				emp = result;
				break;
			}			
		}
		return emp;
	}
	
	public void regEmployee(Company cmp, Employee emp) {
		companyList.get(companyList.indexOf(cmp)).addEmployee(emp);
	}
	
	public void removeEmployee(Employee emp) {
		for(Company cmp: companyList) {
			if(Collections.binarySearch(cmp.getEmployees(), emp) > -1)
				cmp.removeEmployee(emp);
		}
	}
	
	public ArrayList<RoomBooking> searchCompanyRoomBookig(LocalDate date, Employee emp){
		System.out.println(emp.getUsername());
		System.out.println(searchCompany(emp).getName());
		return RoomBooking.getRoomBookingByCompany(this.bookingList, searchCompany(emp).getEmployees(), date);
	}
	
}
