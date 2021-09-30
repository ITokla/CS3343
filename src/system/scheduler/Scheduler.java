package system.scheduler;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimerTask;

public abstract class Scheduler extends TimerTask  {
	
	private String jobName;

	
	Scheduler(String jobName){
		this.jobName = jobName;
	}
	
	public String getJobName() {
		return jobName;
	}
	
	public static LocalDateTime getEarliestDate(int dayOfWeek, LocalTime time) {
		 
		 LocalDateTime now = LocalDateTime.now();
		 
		 if(now.toLocalTime().isBefore(time) && now.toLocalDate().getDayOfWeek().getValue() == dayOfWeek)
			return LocalDateTime.of(now.toLocalDate(), time);
		 
		 LocalDateTime dateTime = LocalDateTime.of(now.toLocalDate(), time);
		 
		 
		 return dateTime.with(TemporalAdjusters.next(DayOfWeek.values()[dayOfWeek]));
	}
	
	public static long getDelay(int dayOfWeek, LocalTime time) {
			
		
		return convertToCalendar(getEarliestDate(dayOfWeek, time)).getTime().getTime() - convertToCalendar(LocalDateTime.now()).getTime().getTime();
	}
	
	public static Calendar convertToCalendar(LocalDateTime datetime) {
		return GregorianCalendar.from(ZonedDateTime.of( datetime, ZoneId.systemDefault()));
	}
	
	
}
