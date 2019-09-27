package com.itlize.project2.DAO;


import java.security.KeyStore.PrivateKeyEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//import org.hibernate.Query;
import com.itlize.project2.Entity.User;


@Repository
@SuppressWarnings("unchecked")
public class UserDAO{
	  private SessionFactory sessionFactory;
	  
	  @Autowired
	  public UserDAO(EntityManagerFactory factory) {
	    if(factory.unwrap(SessionFactory.class) == null){
	      throw new NullPointerException("factory is not a hibernate factory");
	    }
	    this.sessionFactory = factory.unwrap(SessionFactory.class);
	  }

		
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public User get(String username) { 
        User res=null;
        try{
            Session session=sessionFactory.getCurrentSession();
  
            String sql="FROM User u where u.username=:inp_username";
			Query<User> query=session.createQuery(sql);
			query.setParameter("inp_username", username);
            res=(User)query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}

