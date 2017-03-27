package org.test.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.test.dao.RestrictedWordDAO;
import org.test.dao.UsernameDAO;
import org.test.model.RestrictedWord;
import org.test.model.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsernameServiceImpl implements UsernameService {

	@Autowired
	UsernameDAO usernameDao;
	
	@Autowired
	RestrictedWordDAO restrictedWordDao;
	
	@Override
    @Transactional
	public List<Username> getAllUsernames() {
		return usernameDao.getAllUsernames();
	}

	@Transactional
	public Username getUsername(int id) {
		return usernameDao.getUsername(id);
	}

	@Override
    @Transactional
	public int addUsername(Username username) {
		if(usernameDao.usernameExist(username.getValue())) {
			return 1;
		} else {
			List<RestrictedWord> listOfRestrictedWord = restrictedWordDao.getAllRestrictedWords();
			for(RestrictedWord word: listOfRestrictedWord) {
				if(username.getValue().contains(word.getValue())) {
					return 2;
				}
			}
		    usernameDao.addUsername(username);
		    return 0;
		}
	}
	
	@Override
	@Transactional
	public List<String> getAllSuggestedUsernames(String username, Locale loc) {
		Map<String, String> suggestedUsernames = new HashMap<String, String>();
		StringBuilder strBuilder = new StringBuilder();
		//Suggestions with country
		// First suggestion
		strBuilder.append(username).append(loc.getCountry().toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// Second suggestion
		strBuilder.append(username).append(".").append(loc.getCountry().toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// Second suggestion
		strBuilder.append(username).append("-").append(loc.getCountry().toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// Third suggestion
		strBuilder.append(username).append("_").append(loc.getCountry().toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		
		//Suggestions with language
		strBuilder = new StringBuilder();
		// fourth suggestion
		strBuilder.append(username).append(loc.getLanguage());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// Fifth suggestion
		strBuilder.append(username).append(".").append(loc.getLanguage().toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// Sixth suggestion
		strBuilder.append(username).append("-").append(loc.getLanguage().toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// Seventh suggestion
		strBuilder.append(username).append("_").append(loc.getLanguage().toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year  = localDate.getYear();
		DayOfWeek day = localDate.getDayOfWeek();
		
		//Suggestions with year
		strBuilder = new StringBuilder();
		// eight suggestion
		strBuilder.append(username).append(year);
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// ninth suggestion
		strBuilder.append(username).append(".").append(year);
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// tenth suggestion
		strBuilder.append(username).append("-").append(year);
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// eleventh suggestion
		strBuilder.append(username).append("_").append(year);
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		
		Calendar cal = Calendar.getInstance();
		String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, loc);
		//Suggestions with month
		strBuilder = new StringBuilder();
		// twelfth suggestion
		strBuilder.append(username).append(monthName.toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// thirteenth suggestion
		strBuilder.append(username).append(".").append(monthName.toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// fourteenth suggestion
		strBuilder.append(username).append("-").append(monthName.toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// fifteenth suggestion
		strBuilder.append(username).append("_").append(monthName.toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		
		String dayName = day.toString();
		//Suggestions with month
		strBuilder = new StringBuilder();
		// sixteenth suggestion
		strBuilder.append(username).append(dayName.toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// seventeenth suggestion
		strBuilder.append(username).append(".").append(dayName.toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// eighteenth suggestion
		strBuilder.append(username).append("-").append(dayName.toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		// nineteenth suggestion
		strBuilder.append(username).append("_").append(dayName.toLowerCase());
		if(!usernameDao.usernameExist(strBuilder.toString()) && !suggestedUsernames.containsKey(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}		
		
		strBuilder = new StringBuilder();
		// twentieth suggestion
		strBuilder.append(username).append(".").append(new StringBuilder(username).reverse().toString() );
		if(!usernameDao.usernameExist(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		strBuilder = new StringBuilder();
		//	twenty-first suggestion
		strBuilder.append(username).append("-").append(new StringBuilder(username).reverse().toString() );
		if(!usernameDao.usernameExist(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}strBuilder = new StringBuilder();
		// twenty-second suggestion
		strBuilder.append(username).append("_").append(new StringBuilder(username).reverse().toString() );
		if(!usernameDao.usernameExist(strBuilder.toString())){
			suggestedUsernames.put(strBuilder.toString(), strBuilder.toString());
		}
		List<String> suggestedUsernamesList =
			    new ArrayList<String>(suggestedUsernames.values());
		Collections.sort(suggestedUsernamesList);
		return suggestedUsernamesList;
	}

	@Transactional
	public Username updateUsername(Username username) {
		return usernameDao.updateUsername(username);
	}

	@Override
    @Transactional
	public void deleteUsername(Integer id) {
		usernameDao.deleteUsername(id);
	}
}
