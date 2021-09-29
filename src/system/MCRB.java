package system;

import java.util.ArrayList;
import java.util.Collections;

import model.Company;
import model.user.Employee;

public class MCRB extends CRBCore{
	
	// Adapter
	private final static MCRB instance = new MCRB();
	private ArrayList<Company> companyList; 
	
	private MCRB() {
		super();
		companyList = new ArrayList<Company>();
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
	
}
