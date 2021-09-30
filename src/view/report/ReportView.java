package view.report;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import system.MCRB;
import view.NoInputView;

public class ReportView extends NoInputView{
	
	public void printHeader() {
		System.out.println("=========Report Start========");
		System.out.println("Gernate by: " + MCRB.getInstance().getSession().getEmployee().getUsername());
		System.out.println("Credted date: " + LocalDateTime.now());
		System.out.println();
	}
	
	public void printFooter() {
		System.out.println();
		System.out.println("=========Report End==========");
	}
	
	public void printReportMonth(LocalDate date) {
		System.out.println(date.getMonthValue() + "-" + date.getYear() + " Report");
		System.out.println();
	}
	
}
