package com.mystery.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mystery.api.SendEmailUsingGMailSMTP;
import com.mystery.model.User;
@Repository
public class AuthenticDaoImpl implements AuthenticDao {
	@Autowired
	private EntityManager entityManager;
	@Value("${app.url}")
	 private String url;
	 
	 @Value("${mail.from}")
	 private String emailfrom;
	 
	 @Value("${mail.username}")
	 private String emailusername;
	 
	 @Value("${mail.password}")
	 private String emailpassword;

	@SuppressWarnings("unchecked")
	@Override
	public User signin(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
	    Query<Long> query = currentSession.createQuery("select count(*) from User u where u.email=:email and u.password=:password and u.user_status=:status");
	    query.setParameter("email",user.getEmail());
	    query.setParameter("password",user.getPassword());
	    query.setParameter("status","active");
	    
	    Long count = (Long)query.uniqueResult();
	    if(count>0)
	    {
	    	User userDetails= new User();
			Query<User> query1  = currentSession.createQuery("select u from User u where u.email=:email and u.user_status=:status");
	    	query1.setParameter("email",user.getEmail());
	    	query1.setParameter("status","active");
	    	userDetails=query1.getSingleResult();
	    	userDetails.setStatusCode("1");
	    	userDetails.setStatusmessage("Logged in successfully");
	    	
	    	return userDetails;
	      }
	    else {
	    	 User userDetails=new User();
	    	 userDetails.setStatusCode("0");
	    	 userDetails.setStatusmessage("Invalid Credentials");
	    	 return userDetails;
	    
	    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public User forgotPassword(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
	    Query<Long> query = currentSession.createQuery("select count(*) from User u where u.email=:email and u.user_status=:status");
	    query.setParameter("email",user.getEmail());
	    query.setParameter("status","active");
	    
	    Long count = (Long)query.uniqueResult();
	    if(count>0)
	    {
	    	User userDetails= new User();
			Query<User> query1  = currentSession.createQuery("select u from User u where u.email=:email and u.user_status=:status");
	    	query1.setParameter("email",user.getEmail());
	    	query1.setParameter("status","active");
	    	userDetails=query1.getSingleResult();
	    	int user_id=userDetails.getSk_user_id();
	    	String email=userDetails.getEmail();
	    	String link="<td><a href="+url+"resetPassword/"+user_id+">click on the link to reset password</a></td>";
            SendEmailUsingGMailSMTP mail= new SendEmailUsingGMailSMTP();
            mail.forgotPassword(email,link,emailfrom,emailusername,emailpassword);
	    	userDetails.setStatusCode("1");
	    	userDetails.setStatusmessage("Reset Password link sent to your email");
	    	
	    	return userDetails;
	      }
	    else {
	    	 User userDetails=new User();
	    	 userDetails.setStatusCode("0");
	    	 userDetails.setStatusmessage("Email Does Not Exist");
	    	 return userDetails;
	    
	    }
	}
	@Transactional
	@Override
	public User updatePassword(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("UPDATE User u SET u.password =:password  WHERE u.sk_user_id= :userId");
		query.setParameter("userId", user.getSk_user_id());
		query.setParameter("password",user.getPassword());
        int updateCount = query.executeUpdate();
        User userDetails= new User();
        if(updateCount==1)
        {
        	userDetails.setStatusCode("1");
        	userDetails.setStatusmessage("Password Updated Successfully");
        }
		return userDetails;	

	}
}
