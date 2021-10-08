package controller.admin;

import java.util.ArrayList;

import controller.Controller;
import model.Room;
import model.RoomBooking;
import system.MCRB;
import view.RemoveRoomView;

public class RemoveRoomController extends Controller {
	private RemoveRoomView view;
	
	public RemoveRoomController(RemoveRoomView view) {
		this.view = view;
	}
	
	public void execute() {
		String roomName = this.view.getRoomName();
		
		Room room = MCRB.getInstance().searchRoom(roomName);
		if(room == null) {
			view.showMessage("Room not found.");
			return;
		}
		if(this.view.Confirm()) {
			MCRB.getInstance().removeRoom(room);
			ArrayList<RoomBooking> rmList = MCRB.getInstance().removeRoomBooking(room);
			MCRB.getInstance().creaditRefill(rmList);
			view.showCountOfRemovedRoomBooking(rmList.size());
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Remove Room";
	}
}
