package controller.search.cmd;

import java.time.LocalDate;

import system.MCRB;

public class DateSearch extends Search{
	
	public void execute(String[] cmds) {
		
		try {
			if(cmds.length < 1)//bug
				return;
			
			String sortType = (cmds.length < 2)? "ASC": cmds[1];
			LocalDate date = LocalDate.parse(cmds[0]);
			MCRB instance = MCRB.getInstance();
			this.printRoomBookings(this.sort(instance.getRoomBookingByDate(date), this.getSortType(sortType)));
		}catch(Exception e) {
			System.out.println("Can't read the date.");
		}
	}
}
