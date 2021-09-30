package controller.admin;

import java.util.Arrays;
import java.util.LinkedHashMap;

import controller.Controller;
import controller.admin.report.Report;
import factory.ReportCmdFactory;
import view.CommandView;
import view.report.ReportView;

public class ReportController extends Controller{
	private CommandView view;
	private LinkedHashMap<String, Report> map;
	public ReportController(CommandView view) {
		this.view = view;
		this.map = ReportCmdFactory.create();
		this.view.setVerifyCmds(this.map.keySet());
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		view.showMessage("[cmp | room ] [name] [year-month]");
		view.showMessage("[date] [year-month-date]");
		
		String[] cmd = view.getCommand();
		if(cmd != null && map.containsKey(cmd[0]))
			map.get(cmd[0]).execute(Arrays.copyOfRange(cmd, 1, cmd.length));
		else
			view.showMessage("Invaild command.");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Report";
	}

}
