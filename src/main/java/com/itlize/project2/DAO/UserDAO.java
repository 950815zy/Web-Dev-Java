package com.itlize.project2.DAO;


import java.security.KeyStore.PrivateKeyEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.itlize.project2.Entity.Product;
//import org.hibernate.Query;
import com.itlize.project2.Entity.UserDTO;


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
	public UserDTO findByUsername(String username) { 
    		Session session = sessionFactory.getCurrentSession();	
    		String sql="FROM UserDTO u where u.username=:username";
			Query<UserDTO> query=session.createQuery(sql);
			query.setParameter("username", username);
			UserDTO res=(UserDTO)query.uniqueResult();
    		return res;
    }
		
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public UserDTO getUserbyId(Integer uid) { 
    		Session session = sessionFactory.getCurrentSession();	
    		String sql="FROM UserDTO u where u.uid=:uid";
			Query<UserDTO> query=session.createQuery(sql);
			query.setParameter("uid", uid);
			UserDTO res=(UserDTO)query.uniqueResult();
    		return res;
    }
//	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Product getProdbyId(Integer pid) { 
        Product res=null;
        try{
            Session session=sessionFactory.getCurrentSession();
  
            String sql="FROM Product p where p.pid=:inp_pid";
			Query<Product> query=session.createQuery(sql);
			query.setParameter("inp_pid", pid);
            res=(Product)query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
//	
//	
//	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public UserDTO save(UserDTO user) {
        try{
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
//	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public UserDTO add2(Integer prodId, Integer userId) {
		UserDTO user = getUserbyId(userId);
		Product product = getProdbyId(prodId);
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			user.getProduct().add(product);
			product.getUserId().add(user);
			session.update(user);
			tx.commit();
			}
		catch (Exception e) {
            e.printStackTrace();
        }
		return user;
	}
}

