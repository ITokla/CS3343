package controller;

import system.CRB;
import view.RemoveRoomView;

public class RemoveRoomController extends Controller {
	private RemoveRoomView view;
	
	public RemoveRoomController(RemoveRoomView view) {
		this.view = view;
	}
	
	public void execute() {
		String roomName = this.view.getRoomName();
		if(this.view.Confirm())
			CRB.getInstance().addRoom(CRB.getInstance().searchRoom(roomName));
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Remove Room";
	}
}
