package org.test.dao;

import java.util.List;

import org.test.model.Username;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsernameDAOImpl implements UsernameDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUsername(Username username) {
		sessionFactory.getCurrentSession().saveOrUpdate(username);
	}
	
	@SuppressWarnings("unchecked")
	public List<Username> getAllUsernames() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Username")
				.list();
	}

	@Override
	public void deleteUsername(Integer usernameId) {
		Username username = (Username) sessionFactory
				.getCurrentSession()
          .load(Username.class, usernameId);
		if (null != username) {
			this.sessionFactory.getCurrentSession().delete(username);
		}
	}

	public Username getUsername(int usernameId) {
		return (Username) sessionFactory.getCurrentSession()
				.get(Username.class, usernameId);
    }

	@Override
	public Username updateUsername(Username username) {
		sessionFactory.getCurrentSession().update(username);
		return username;
    }
	
	@Override
	public boolean usernameExist(String username) {
		if (null != (Username)sessionFactory.getCurrentSession()
				.createQuery("from Username where value='"+username+"'")
				.uniqueResult()) {
			return true;
		} else {
			return false;
		}
	}
}