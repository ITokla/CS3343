package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

import factory.RoomBookingStaticTimeFactory;
import model.Room;
import model.RoomBooking;
import system.CRB;
import view.RoomBookingView;

public class RoomBookingController extends Controller {

	RoomBookingView view;

	public RoomBookingController(RoomBookingView view) {
		this.view = view;
	}

	public void execute() {
		
		try {

			LocalDate bookDate = view.getDate();
			if(bookDate == null || !isVerifyDate(bookDate)) {
				view.showMessage("Date must be >= now.");
				return;
			}
			
			CRB instance = CRB.getInstance();
			view.showDateRoomingDetails(bookDate, instance.getRooms(), instance.getRoomBookingByDate(bookDate));

			String roomName = view.getRoomName();
			// Search room whether exist
			Room room = searchRoom(roomName);
			if (room == null) {
				view.showMessage("Room not found");
				return;
			}

			ArrayList<LocalTime> avaiableStartTimes = getAvailableStartTime(bookDate, room);

			if (avaiableStartTimes == null || avaiableStartTimes.size() == 0) {
				view.showMessage("Not any avaiable time.");
				return;
			}

			LocalTime startTime = view.selectTime(avaiableStartTimes);

			ArrayList<LocalTime> avaiableEndTimes = getAvailableEndTime(bookDate, room, startTime);

			if (avaiableEndTimes == null || avaiableEndTimes.size() == 0) {
				view.showMessage("Not any avaiable endTime choose.");
				return;
			}

			LocalTime endTime = view.selectTime(avaiableEndTimes);

			RoomBooking rb = CRB.getInstance().addRoomBooking(room, bookDate, startTime, endTime);
			System.out.println(rb);

		} catch (NumberFormatException e) {
			System.out.println("Cannot read the date.");
		}
	}
	
	// Verify date, which must be >= now
	public boolean isVerifyDate(LocalDate date) {
		return date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now());
	}
	
	// Search Room
	public Room searchRoom(String roomName) {
		return CRB.getInstance().searchRoom(roomName);
	}

	public ArrayList<LocalTime> getAvailableEndTime(LocalDate date, Room room, LocalTime startTime) {
		ArrayList<LocalTime> allAvaiableTime = RoomBookingStaticTimeFactory.create();
		ArrayList<RoomBooking> bookings = CRB.getInstance().searchBooking(date, room);
		// Remove all booking is before the start date
		allAvaiableTime = RemoveBookingExist(allAvaiableTime, bookings, startTime);
		// Remove < starttime LocalTime
		allAvaiableTime = RemoveBeforeStartTime(allAvaiableTime, startTime);

		return (allAvaiableTime.size() > 0) ? allAvaiableTime : null;

	}

	public ArrayList<LocalTime> RemoveBookingExist(ArrayList<LocalTime> allAvaiableTime,
			ArrayList<RoomBooking> bookings, LocalTime startTime) {
		// If have booking
		if (bookings.size() > 0) {

			// Remove all booking is before the start date
			for (Iterator<RoomBooking> it = bookings.iterator(); it.hasNext();) {
				if (it.next().getStartTime().isBefore(startTime)) {
					it.remove();
				}
			}

			// After Remove
			if (bookings.size() > 0) {
				RoomBooking nearRoomBooking = bookings.get(0);
				// Find near startdate booking
				for (int i = 0; i < bookings.size(); i++) {
					if (bookings.get(i).getStartTime().isBefore(nearRoomBooking.getStartTime()))
						nearRoomBooking = bookings.get(i);
				}
				// delete all booking date expect near booking starttime
				int i;
				for (i = 0; i < allAvaiableTime.size(); i++) {
					if (allAvaiableTime.get(i).isAfter(nearRoomBooking.getStartTime()))
						break;
				}
				allAvaiableTime.subList(i, allAvaiableTime.size()).clear();

			}

		}
		return allAvaiableTime;
	}

	public ArrayList<LocalTime> RemoveBeforeStartTime(ArrayList<LocalTime> allAvaiableTime, LocalTime startTime) {
		// Remove < starttime LocalTime
		if (allAvaiableTime.size() > 1) {
			int i;
			for (i = 0; i < allAvaiableTime.size(); i++) {
				if (!allAvaiableTime.get(i).isBefore(startTime))
					break;
			}

			int count = i;
			while (count >= 0) {
				allAvaiableTime.remove(0);
				count--;
			}
		}
		return allAvaiableTime;
	}

	// Get List for available start time
	public ArrayList<LocalTime> getAvailableStartTime(LocalDate date, Room room) {
		ArrayList<RoomBooking> bookings = CRB.getInstance().searchBooking(date, room);
		ArrayList<LocalTime> allAvaiableTime = RoomBookingStaticTimeFactory.create();

		// Remove all booked time
		for (RoomBooking rb : bookings) {
			LocalTime startTime = rb.getStartTime();
			while (startTime.isBefore(rb.getEndTime())) {
				allAvaiableTime.remove(startTime);
				startTime = startTime.plusMinutes(30);
			}
		}

		return (allAvaiableTime.size() > 0) ? allAvaiableTime : null;
	}

	public String getDescription() {
		return "Room Booking";
	}

}
