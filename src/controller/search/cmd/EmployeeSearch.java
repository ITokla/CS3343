package controller.search.cmd;

import model.user.Employee;
import system.MCRB;

public class EmployeeSearch extends Search {
	
	public void execute(String[] cmds) {
		if(cmds.length < 1)
			return;
		
		String sortType = (cmds.length < 2)? "ASC": cmds[1];
		MCRB instance = MCRB.getInstance();
		Employee emp = instance.searchEmployee(cmds[0]);
		if(emp == null)
			return;
		this.printRoomBookings(this.sort(instance.getRoomBookingByEmployee(emp), this.getSortType(sortType)));
		
	}
}
