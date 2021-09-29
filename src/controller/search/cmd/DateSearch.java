package controller.search.cmd;

import java.time.LocalDate;

import system.CRB;

public class DateSearch extends Search{
	
	public void execute(String[] cmds) {
		
		if(cmds.length < 1)
			return;
		
		String sortType = (cmds.length < 2)? "ASC": cmds[1];
		LocalDate date = LocalDate.parse(cmds[0]);
		CRB instance = CRB.getInstance();
		this.printRoomBookings(this.sort(instance.getRoomBookingByDate(date), this.getSortType(sortType)));
		
	}
}
