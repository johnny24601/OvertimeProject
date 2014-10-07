package uk.co.tpplc.local.timesheet.service;

public interface AuthenticationService {
	
	public Boolean validateLogin(String userName, String password); 
}
