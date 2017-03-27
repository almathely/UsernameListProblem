package org.test.dao;

import java.util.List;
import org.test.model.RestrictedWord;
 
public interface RestrictedWordDAO {
 
    public void addRestrictedWord(RestrictedWord restricteWord);
 
    public List<RestrictedWord> getAllRestrictedWords();
 
    public void deleteRestrictedWord(Integer restricteWordId);
 
    public RestrictedWord updateRestrictedWord(RestrictedWord restricteWord);
 
    public RestrictedWord getRestrictedWord(int restricteWordId);
}