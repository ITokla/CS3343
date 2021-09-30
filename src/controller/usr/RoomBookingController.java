package controller.usr;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

import controller.Controller;
import factory.RoomBookingStaticTimeFactory;
import model.Credit;
import model.Room;
import model.RoomBooking;
import system.MCRB;
import util.Time;
import view.RoomBookingView;

public class RoomBookingController extends Controller {

	private RoomBookingView view;

	public RoomBookingController(RoomBookingView view) {
		this.view = view;
	}

	public void execute() {
		
		try {
			// Get user input date
			LocalDate bookDate = view.getDate();
			
			// check date whether verify( >= now)
			if(bookDate == null || !isVerifyDate(bookDate)) {
				view.showMessage("Date must be >= now.");
				return;
			}
			
			MCRB instance = MCRB.getInstance();
			
			// Get All rooms
			ArrayList<Room> rooms = instance.getRooms();
			if(rooms.size() == 0) {
				view.showMessage("No any room avaiable.");
				return;
			}
			
			
			
			// Display room details and let user input the room
			RoomBookingView.showDateRoomingDetails(bookDate, rooms, instance.getRoomBookingByDate(bookDate));
			
			
			String roomName = view.getRoomName();
			
			// Get Company Credit
			Credit credit = MCRB.getInstance().searchCompany(MCRB.getInstance().getSession().getEmployee()).getCredit();
			view.showMessage("Company Credit: " + credit.toMinutes());
			
			// Search room whether exist
			Room room = searchRoom(roomName);
			if (room == null) {
				view.showMessage("Room not found");
				return;
			}
			
			
			
			if(credit.toMinutes() < 30) {
				view.showMessage("Credit insufficient.");
				return;
			}
				
			// find room available time
			ArrayList<LocalTime> avaiableStartTimes = getAvailableStartTime(bookDate, room);

			if (avaiableStartTimes == null || avaiableStartTimes.size() == 0) {
				view.showMessage("Not any avaiable time.");
				return;
			}
			
			int index = view.selectList(avaiableStartTimes);
			
			// User input EXIT
			view.showMessage(roomName);
			if(index == avaiableStartTimes.size())
				return;
			
			LocalTime startTime = avaiableStartTimes.get(index);
			
			
			ArrayList<LocalTime> avaiableEndTimes = getAvailableEndTime(bookDate, room, startTime);

			if (avaiableEndTimes == null || avaiableEndTimes.size() == 0) {
				view.showMessage("Not any avaiable endTime choose.");
				return;
			}
			
			avaiableEndTimes = RemoveTimeByCredit(avaiableEndTimes, startTime, credit);
			
			index = view.selectList(avaiableEndTimes);
			
			// user input EXIT
			if(index == avaiableEndTimes.size())
				return;
			
			LocalTime endTime =  avaiableEndTimes.get(index);

			RoomBooking rb = MCRB.getInstance().addRoomBooking(room, bookDate, startTime, endTime);
			System.out.println(rb);
			credit.setHour((credit.toMinutes() - Time.durationMinutes(startTime, endTime))/60);

		}  catch (Exception e) {
			System.out.println("Cannot read the date." + e);
		}
	}
	
	// Verify date, which must be >= now
	public boolean isVerifyDate(LocalDate date) {
		return date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now());
	}
	
	// Search Room
	public Room searchRoom(String roomName) {
		return MCRB.getInstance().searchRoom(roomName);
	}

	public ArrayList<LocalTime> getAvailableEndTime(LocalDate date, Room room, LocalTime startTime) {
		ArrayList<LocalTime> allAvaiableTime = RoomBookingStaticTimeFactory.create();
		ArrayList<RoomBooking> bookings = MCRB.getInstance().searchBooking(date, room);
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
	
	public ArrayList<LocalTime> RemoveTimeByCredit(ArrayList<LocalTime> allAvaiableTime, LocalTime startTime, Credit credit){
		
		int removeAfterIndex = 0;
		
		for(LocalTime time: allAvaiableTime) {
			if(Time.durationMinutes(startTime, time) > credit.toMinutes())
				break;
			removeAfterIndex++;
		}
		
		return new ArrayList<LocalTime>(allAvaiableTime.subList(0, removeAfterIndex));
		
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
		ArrayList<RoomBooking> bookings = MCRB.getInstance().searchBooking(date, room);
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
