package factory;

import java.util.LinkedHashMap;
import java.util.Scanner;

import controller.Controller;
import controller.LogoutController;
import controller.ReviewOwnBooking;
import controller.RoomBookingCancelController;
import controller.RoomBookingController;
import controller.RoomBookingSearchController;
import controller.UserCreateController;
import view.LogoutView;
import view.ReviewOwnBookingView;
import view.RoomBookingCancelView;
import view.RoomBookingSearchView;
import view.RoomBookingView;
import view.UserCreateView;


public class MenuFactory {
	public static LinkedHashMap<String, Controller> create(Scanner input){
		LinkedHashMap<String, Controller> map = new LinkedHashMap<>();
		map.put("rb", new RoomBookingController(new RoomBookingView(input)));
		map.put("rbc", new RoomBookingCancelController(new RoomBookingCancelView(input)));
		map.put("search", new RoomBookingSearchController(new RoomBookingSearchView(input)));
		map.put("own", new ReviewOwnBooking(new ReviewOwnBookingView(input)));
		map.put("ce", new UserCreateController(new UserCreateView(input)));
		map.put("logout", new LogoutController(new LogoutView(input)));
		return map;
	}
}