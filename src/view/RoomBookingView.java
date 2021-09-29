package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import model.Room;
import model.RoomBooking;

public class RoomBookingView extends View {

	public RoomBookingView(Scanner input) {
		super(input);
	}


	public LocalDate getDate() throws NumberFormatException{
		System.out.print("Please select month (Example: 2021-09/ 2021-09-26): ");
		String selectedMonth = input.nextLine();
		String[] selectedDate = selectedMonth.trim().split("-");

		// Check user input date is 2021-09 or full date (2021-09-21)
		if (selectedDate.length != 2 && selectedDate.length != 3)
			throw new NumberFormatException();
		
		int year = Integer.parseInt(selectedDate[0]);
		int month = Integer.parseInt(selectedDate[1]);
		LocalDate date = LocalDate.of(year, month, 1);
		if(selectedDate.length == 2) {
			showCalendar(date);
			System.out.print("Please enter day: ");
			date = date.withDayOfMonth(Integer.parseInt(input.nextLine()));
		}else 
			date = date.withDayOfMonth(Integer.parseInt(selectedDate[2]));
		
		return date;
	}
	

	// Input room name
	public String getRoomName() {
		System.out.print("Please enter Room name:");
		return input.nextLine();
	}
	
	// print calender by date if the user only input year and month
	public void showCalendar(LocalDate date) {
		LocalDate today = LocalDate.now();
		int dayOfWeek = date.getDayOfWeek().getValue();
		int monthLength = date.lengthOfMonth();
		
		System.out.println("  S   M   T   W   T   F   S");
		for(int i = 0; i < dayOfWeek -1; i++)
			System.out.print("    ");
		
		
		for (int i = 0, dayOfMonth = 1; dayOfMonth <= monthLength; i++) {
			   for (int j = ((i == 0) ? dayOfWeek - 1 : 0); j < 7 && (dayOfMonth <= monthLength); j++) {
			   	if(isEqualMonth(today, date) && today.getDayOfMonth() == dayOfMonth)
			   		System.out.printf(" %2s*", dayOfMonth);
			   	else
			   		System.out.printf("%3d ", dayOfMonth);
		       dayOfMonth++;
			    }
		   System.out.println();
		}
	}
	
	// print Room booking detail by date
	public void showDateRoomingDetails(LocalDate date, ArrayList<Room> rooms, ArrayList<RoomBooking> bookings) {
			
		LocalTime startTime = LocalTime.of(9, 0);
		LocalTime endTime = LocalTime.of(20, 30);
		
		System.out.printf("%-9s", " ");
		for (Room rm: rooms)
			System.out.printf("%" + (rm.getRoomName().length())+"s ", rm.getRoomName());
		System.out.println();
		
		while(startTime.isBefore(endTime)) {
			System.out.printf("%-6s%-2s ", startTime, "|");
			for(Room rm: rooms) {
				boolean booked = false;
				for (RoomBooking rb: bookings) {
					if (rb.getRoom() == rm && (startTime.equals(rb.getStartTime()) || startTime.isAfter(rb.getStartTime()) && startTime.isBefore(rb.getEndTime())) ){
						booked = true;
					}
				}
				if(!booked)
					System.out.printf("%" + rm.getRoomName().length()+"s ", "[x]");
				else
					System.out.printf("%" + rm.getRoomName().length()+"s ", "[v]");
			}
			System.out.println();
			startTime = startTime.plusMinutes(30);
		}
	}
	
	public boolean isEqualMonth(LocalDate date, LocalDate compareDate) {
		return (date.getYear()==compareDate.getYear() && date.getMonthValue() == compareDate.getMonthValue());
	}

}
