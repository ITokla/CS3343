package controller.admin;

import controller.Controller;
import model.Room;
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
		if(this.view.Confirm())
			MCRB.getInstance().removeRoom(room);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Remove Room";
	}
}
