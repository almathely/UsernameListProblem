package org.test.dao;

import java.util.List;

import org.test.model.RestrictedWord;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestrictedWordDAOImpl implements RestrictedWordDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addRestrictedWord(RestrictedWord restrictedWord) {
		sessionFactory.getCurrentSession().saveOrUpdate(restrictedWord);
	}
	
	@SuppressWarnings("unchecked")
	public List<RestrictedWord> getAllRestrictedWords() {
		return sessionFactory.getCurrentSession()
				.createQuery("from RestrictedWord")
				.list();
	}

	@Override
	public void deleteRestrictedWord(Integer employeeId) {
		RestrictedWord restrictedWord = (RestrictedWord) sessionFactory
				.getCurrentSession()
          .load(RestrictedWord.class, employeeId);
		if (null != restrictedWord) {
			this.sessionFactory.getCurrentSession().delete(restrictedWord);
		}
	}

	public RestrictedWord getRestrictedWord(int restrictedWordId) {
		return (RestrictedWord) sessionFactory.getCurrentSession()
				.get(RestrictedWord.class, restrictedWordId);
    }

	@Override
	public RestrictedWord updateRestrictedWord(RestrictedWord restrictedWord) {
		sessionFactory.getCurrentSession().update(restrictedWord);
		return restrictedWord;
	}
}