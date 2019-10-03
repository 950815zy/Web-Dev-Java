package com.itlize.project2.config;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final UserDetails userDetails;
	private final Date expirationDate;


	public JwtResponse(String jwttoken, UserDetails userDetails, Date expirationDate) {
		super();
		this.jwttoken = jwttoken;
		this.userDetails = userDetails;
		this.expirationDate = expirationDate;
	}


	public Date getExpirationDate() {
		return expirationDate;
	}


	public UserDetails getUserDetails() {
		return userDetails;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
