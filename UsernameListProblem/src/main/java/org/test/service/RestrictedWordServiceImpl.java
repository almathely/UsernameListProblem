package org.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import org.test.dao.RestrictedWordDAO;
import org.test.model.RestrictedWord;

@Service
@Transactional
public class RestrictedWordServiceImpl implements RestrictedWordService{

	@Autowired
	RestrictedWordDAO restrictedWordDao;
	
	@Override
    @Transactional
	public List<RestrictedWord> getAllRestrictedWords() {
		return restrictedWordDao.getAllRestrictedWords();
	}

	@Transactional
	public RestrictedWord getRestrictedWord(int id) {
		return restrictedWordDao.getRestrictedWord(id);
	}

	@Override
    @Transactional
	public void addRestrictedWord(RestrictedWord restrictedWord) {
		restrictedWordDao.addRestrictedWord(restrictedWord);
	}

	@Transactional
	public RestrictedWord updateRestrictedWord(RestrictedWord restrictedWord) {
		return restrictedWordDao.updateRestrictedWord(restrictedWord);
	}

	@Override
    @Transactional
	public void deleteRestrictedWord(Integer id) {
		restrictedWordDao.deleteRestrictedWord(id);
	}
}
