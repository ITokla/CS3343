package controller.admin.report;

import java.time.LocalDate;

public abstract class Report {
	
	public abstract void execute(String args[]);
	public LocalDate parseDate(String dateStr) {
		String[] dateArray = dateStr.split("-");
		return LocalDate.of(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), 1);
	}
}
