package uk.co.tpplc.local.overtime.service;

import java.util.ArrayList;

public interface AuthenticationService {
	
	public Boolean validateLogin(String userName, String password);

	public ArrayList<String> fetchEntryType(); 
}
