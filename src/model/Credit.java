package model;

import java.time.LocalDateTime;

public class Credit {
	private double credit;
	private LocalDateTime createDate;
	
	public Credit(double credit) {
		this.credit = credit;
		this.createDate = LocalDateTime.now();
	}
	
	public double toHours() {
		return credit;
	}
	
	public double toMinutes() {
		return credit * 60;
	}
	
	public void setHour(double credit) {
		this.credit = credit;
	}
	
	public void setMinute(double minute) {
		this.credit = minute/60;
	}
}
