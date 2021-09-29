package controller.search.cmd;

import system.CRB;

public class RoomSearch extends Search{
	
	public void execute(String[] cmds) {
		if(cmds.length > 2)
			return;
		
		String sortType = (cmds.length < 2)? "ASC": cmds[1];
		CRB instance = CRB.getInstance();
		this.printRoomBookings(this.sort(instance.getRoomBookingByRoomName(cmds[0]), this.getSortType(sortType)));
	}
}
