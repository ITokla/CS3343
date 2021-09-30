package factory;

import java.util.LinkedHashMap;

import controller.admin.report.CompanyReport;
import controller.admin.report.DateReport;
import controller.admin.report.Report;
import controller.admin.report.RoomReport;



public class ReportCmdFactory {
	public static LinkedHashMap<String, Report> create(){
		LinkedHashMap<String, Report> map = new LinkedHashMap<String, Report>();
		map.put("cmp", new CompanyReport());
		map.put("date", new DateReport());
		map.put("room", new RoomReport());
		return map;
	}
}
