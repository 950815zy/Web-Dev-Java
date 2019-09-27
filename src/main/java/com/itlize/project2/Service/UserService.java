package com.itlize.project2.Service;
import com.itlize.project2.DAO.UserDAO;
import com.itlize.project2.Entity.User;
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
	
	public User getbyUser(String uname) {
		return userDAO.get(uname);
	}
	
}
