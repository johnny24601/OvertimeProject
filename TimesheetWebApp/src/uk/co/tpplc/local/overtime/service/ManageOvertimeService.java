package uk.co.tpplc.local.overtime.service;

import javax.servlet.http.HttpServletRequest;

public interface ManageOvertimeService {
	public abstract Boolean writeOvertimeToDB(HttpServletRequest request);
	
	public abstract void readOvertimeFromDB(HttpServletRequest request);
}
