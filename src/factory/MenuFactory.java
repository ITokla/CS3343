package factory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import controller.Controller;
import controller.LogoutController;
import controller.admin.AddRoomController;
import controller.admin.ExtraCreditController;
import controller.admin.RemoveRoomController;
import controller.admin.ReportController;
import controller.admin.UserCreateController;
import controller.admin.UserPasswordResetController;
import controller.admin.UserRemoveController;
import controller.usr.ReviewOwnBooking;
import controller.usr.RoomBookingCancelController;
import controller.usr.RoomBookingController;
import controller.usr.RoomBookingSearchController;
import controller.usr.RoomBookingViewOnlyController;
import model.Session;
import view.AddRoomView;
import view.CommandView;
import view.ExtraCreditView;
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
		
		map.put("uc", new UserCreateController(new UserCreateView(input)));
		map.put("ur", new UserRemoveController(new UserRemoveView(input)));
		map.put("upwdrest", new UserPasswordResetController(new UserPasswordResetView(input)));
		map.put("rr", new RemoveRoomController(new RemoveRoomView(input)));
		map.put("ar", new AddRoomController(new AddRoomView(input)));

		
		map.put("rep", new ReportController(new CommandView(input)));
		map.put("credit", new ExtraCreditController(new ExtraCreditView(input)));
		
		
		return map;
	}
}