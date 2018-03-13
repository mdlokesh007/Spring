package com.spring.mvc.dto;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.pojo.UserDetails;

@Repository
public class UserDetailsDTO2 implements IUserDetailsDTO {

	@Autowired
	private SessionFactory factory; 

	public void saveUser(UserDetails user){
		System.out.println("UserDetailsDTO 2 implementation");

        Session session = factory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        session.save(user);
        beginTransaction.commit();
        session.close();
	}
	
	public List<UserDetails> getAllUsers(){
		System.out.println("UserDetailsDTO 2 implementation");
 
//        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Query createQuery = session.createQuery("FROM UserDetails");
        List<UserDetails> list = (List<UserDetails>)createQuery.list();
        beginTransaction.commit();
        session.close();
        return list;
	}
	
	public void deleteUser(int id) {
	        Session session = factory.openSession();
	        Transaction beginTransaction = session.beginTransaction();
	        Query createQuery = session.createQuery("FROM UserDetails where userId ='"+id+"'");
	        List<UserDetails> list = (List<UserDetails>)createQuery.list();
	        for(UserDetails ud :list) {
	        	session.delete(ud);
	        }
	        beginTransaction.commit();
	        session.close();
		
	}
	public void updateUser(UserDetails user) {
		 
	        Session session = factory.openSession();
	        Transaction beginTransaction = session.beginTransaction();
	        UserDetails user1=(UserDetails)session.get(UserDetails.class, user.getUserId());
//	        Query createQuery = session.createQuery("FROM UserDetails where name ='"+user.getName()+"'");
//	        List<UserDetails> list = (List<UserDetails>)createQuery.list();
//	        UserDetails user1=list.get(0);
	        user1.setName(user.getName());
	        user1.setPhone(user.getPhone());
	        user1.setCity(user.getCity());
	        session.update(user1);
	        beginTransaction.commit();
	        session.close();
		
	}

	public UserDetails getUser(int id) {
        Session session = factory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        UserDetails user=(UserDetails)session.get(UserDetails.class, id);
        beginTransaction.commit();
        session.close();
		return user;
	}
	
}
