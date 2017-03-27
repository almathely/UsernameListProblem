package org.test.service;

import java.util.List;
import java.util.Locale;

import org.test.model.Username;

public interface UsernameService {
	
	public int addUsername(Username username);
	 
    public List<Username> getAllUsernames();
 
    public void deleteUsername(Integer usernameId);
 
    public Username getUsername(int usernameId);
 
    public Username updateUsername(Username username);
    
    public List<String> getAllSuggestedUsernames(String username, Locale loc);
}
