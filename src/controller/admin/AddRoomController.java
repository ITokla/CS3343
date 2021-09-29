package controller.admin;

import controller.Controller;
import model.Room;
import system.CRB;
import view.AddRoomView;

public class AddRoomController extends Controller{
	protected AddRoomView view;
	public AddRoomController(AddRoomView view) {
		this.view = view;
	}
	
	public void execute() {
		Room room = this.view.createRoom();
		CRB.getInstance().addRoom(room);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Add Room";
	}
}
