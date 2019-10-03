package com.itlize.project2.Service;
import com.itlize.project2.DAO.UserDAO;
import com.itlize.project2.Entity.Product;
import com.itlize.project2.Entity.UserDTO;
import java.util.List;
import java.io.*;
import java.util.Date;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;

// import org.hibernate.Session;
// import org.hibernate.annotations.GenericGenerator;
// import org.omg.CORBA.PUBLIC_MEMBER;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Repository;
// import org.apache.log4j.Logger;
// import com.sun.xml.internal.bind.v2.runtime.Name;
// import sun.security.util.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.Exception;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDAO userDAO;
//	
	public UserDTO getbyUser(Integer uid) {
		return userDAO.getUserbyId(uid);
	}
	
	public Product getbyProduct(Integer pid) {
		return userDAO.getProdbyId(pid);
	}
////	
//	public UserDTO signUp(UserDTO u) {
//		if (userDAO.getUserbyId(u.getUid()) != null) {
//			System.out.println("Username exists.");
//		}
//		else{
//			userDAO.add(u.getUsername(),u.getPassword());
//			System.out.println("a new user added..");
//		}
//		return u;
//	}
////	
////	public User verification(String uname, String pass) {
////        if(userDAO.getUserbyId(uname) != null && userDAO.getUserbyId(uname).getPassword().equals(pass)){
////            System.out.println("a login accepted..");
////		}
////		else{
////			System.out.println("a login denied..");
////		}
////		return userDAO.getUserbyId(uname);
////	}
//
	public UserDTO add(Integer pid, Integer uid) {
		return userDAO.add2(pid,uid);
	}
}
