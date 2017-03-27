package org.test.dao;

import java.util.List;
import org.test.model.Username;
 
public interface UsernameDAO {
 
    public void addUsername(Username username);
 
    public List<Username> getAllUsernames();
 
    public void deleteUsername(Integer username);
 
    public Username updateUsername(Username username);
 
    public Username getUsername(int usernameId);
    
    public boolean usernameExist(String username);
}