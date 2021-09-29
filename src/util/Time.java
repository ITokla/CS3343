package util;

import java.time.Duration;
import java.time.LocalTime;

public class Time {
	
	public static long durationMinutes(LocalTime startTime, LocalTime endTime) {
		Duration duration = Duration.between(startTime, endTime); 
		return duration.toMinutes();
	}
	
}
