package uk.co.tpplc.local.timesheet.service;

import javax.servlet.http.HttpServletRequest;

public interface ManageTimesheetService {
	public abstract Boolean writeTimesheetToDB(HttpServletRequest request);
	
	public abstract void readTimesheetFromDB(HttpServletRequest request);
}
