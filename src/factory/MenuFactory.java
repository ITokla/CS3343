package factory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import controller.AddRoomController;
import controller.Controller;
import controller.LogoutController;
import controller.RemoveRoomController;
import controller.ReviewOwnBooking;
import controller.RoomBookingCancelController;
import controller.RoomBookingController;
import controller.RoomBookingSearchController;
import controller.RoomBookingViewOnlyController;
import controller.UserCreateController;
import controller.UserPasswordResetController;
import controller.UserRemoveController;
import model.Session;
import view.AddRoomView;
import view.LogoutView;
import view.RemoveRoomView;
import view.ReviewOwnBookingView;
import view.RoomBookingCancelView;
import view.RoomBookingSearchView;
import view.RoomBookingView;
import view.UserCreateView;
import view.UserPasswordResetView;
import view.UserRemoveView;


public class MenuFactory {
	
	public static LinkedHashMap<String, Controller> create(Session session, Scanner input){
		LinkedHashMap<String, Controller> cmdList = getCommandList(input);
		LinkedHashMap<String, Controller> map = new LinkedHashMap<String, Controller>();
		HashMap<String, Boolean> permiMap = session.getEmployee().getPermission().getMap();
		
		for(String key:permiMap.keySet()) {
			if(cmdList.containsKey(key) && permiMap.get(key).booleanValue())
				map.put(key, cmdList.get(key));
		}
		map.put("logout", new LogoutController(new LogoutView(input)));
		return map;
	}
	
	// Menu List, new function please add here it will based on your put order to show the command
	private static LinkedHashMap<String, Controller> getCommandList(Scanner input){
		LinkedHashMap<String, Controller> map = new LinkedHashMap<>();
		map.put("rb", new RoomBookingController(new RoomBookingView(input)));
		map.put("rbc", new RoomBookingCancelController(new RoomBookingCancelView(input)));
		map.put("search", new RoomBookingSearchController(new RoomBookingSearchView(input)));
		map.put("own", new ReviewOwnBooking(new ReviewOwnBookingView(input)));
		map.put("vra", new RoomBookingViewOnlyController(new RoomBookingView(input)));
		
		map.put("ur", new UserRemoveController(new UserRemoveView(input)));
		map.put("uc", new UserCreateController(new UserCreateView(input)));
		map.put("upwdrest", new UserPasswordResetController(new UserPasswordResetView(input)));
		
		map.put("rr", new RemoveRoomController(new RemoveRoomView(input)));
		map.put("ar", new AddRoomController(new AddRoomView(input)));
		return map;
	}
}