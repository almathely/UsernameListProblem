package org.test.service;

import java.util.List;
import org.test.model.RestrictedWord;

public interface RestrictedWordService {
	
	public void addRestrictedWord(RestrictedWord restrictedWord);
	 
    public List<RestrictedWord> getAllRestrictedWords();
 
    public void deleteRestrictedWord(Integer restrictedWordId);
 
    public RestrictedWord getRestrictedWord(int restrictedWordId);
 
    public RestrictedWord updateRestrictedWord(RestrictedWord restrictedWord);
}
