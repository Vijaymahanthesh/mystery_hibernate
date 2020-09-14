package com.mystery.dao;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mystery.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private EntityManager entityManager;

	@Transactional
	@Override
	public void createUser(User user) {
	Session currentSession = entityManager.unwrap(Session.class);
	currentSession.saveOrUpdate(user);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public User checkEmailExistOrNot(User user, String email) {
		
		Session currentSession = entityManager.unwrap(Session.class);
	    Query<Long> query = currentSession.createQuery("select count(*) from User u where u.email=:email and u.user_status=:status");
	    query.setParameter("email",email);
	    query.setParameter("status","active");
	    Long count = (Long)query.uniqueResult();
	    if(count>0)
	    {
	    	User emailDetails= new User();
	    	emailDetails.setStatusCode("1");
	    	emailDetails.setStatusmessage("Email Alredy Exists");
	    	 return emailDetails;
	    }
	    else 
	    {
	    	User emailDetails= new User();
	    	emailDetails.setStatusCode("0");
	    	emailDetails.setStatusmessage("Email Does Not Exists");
	    	return emailDetails;
	    }
		
	}

	@Override
	public List<User> getUserList() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query = currentSession.createQuery("from User u  where u.user_status='active'", User.class);
		List<User>userList = query.getResultList();
		return userList;
	}
    
	@Override
	public List<User> getInactiveUserList() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query = currentSession.createQuery("from User u  where u.user_status='inactive'", User.class);
		List<User>userList = query.getResultList();
		return userList;
	}
	
	
	@Override
	public User getUserDetailsById(int userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		User userDetails = currentSession.get(User.class, userId);
		return userDetails;
	}

	@Transactional
	@Override
	public User deleteUserById(int userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("UPDATE User u SET u.user_status =:inactive  WHERE u.sk_user_id= :userId");
		query.setParameter("userId", userId);
		query.setParameter("inactive","inactive");
        int updateCount = query.executeUpdate();
        User userDetails= new User();
        if(updateCount==1)
        {
        	userDetails.setStatusCode("1");
        	userDetails.setStatusmessage("Deleted Successfully");
        }
		return userDetails;	
	}
	@Transactional
	@Override
	public User restoreUserById(int userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("UPDATE User u SET u.user_status =:active  WHERE u.sk_user_id= :userId");
		query.setParameter("userId", userId);
		query.setParameter("active","active");
        int updateCount = query.executeUpdate();
        User userDetails= new User();
        if(updateCount==1)
        {
        	userDetails.setStatusCode("1");
        	userDetails.setStatusmessage("Restored Successfully");
        }
		return userDetails;	
	}
	
}
