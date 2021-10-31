package controller.admin;

import controller.Controller;
import model.Room;
import system.MCRB;
import view.AddRoomView;

public class AddRoomController extends Controller{
	protected AddRoomView view;
	public AddRoomController(AddRoomView view) {
		this.view = view;
	}
	
	public void execute() {
		Room room = this.view.createRoom();
		if(MCRB.getInstance().searchRoom(room.getRoomName()) != null) {//test1
			view.showMessage("Room name is already.");
			return;
		}
		MCRB.getInstance().addRoom(room);//test2
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Add Room";
	}
}
