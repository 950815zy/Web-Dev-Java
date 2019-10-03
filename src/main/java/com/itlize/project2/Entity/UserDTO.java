package com.itlize.project2.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * User
 */
@Entity
@Table(name = "User")
public class UserDTO {
    @Id
    @GenericGenerator(name="asc_gen", strategy = "increment")
    @GeneratedValue(generator = "asc_gen")
    @Column(name = "uid")
    Integer uid;
    
	@Column(name = "username", nullable = false)
    String username;

    @Column(name = "password", nullable = false)
    String password;


	@JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "productcast", joinColumns = {@JoinColumn(name = "uid")},
    inverseJoinColumns = {@JoinColumn(name = "pid")})
    private Set<Product> product = new HashSet<Product>();
  
	public Set<Product> getProduct() {
		return product;
	}
	
    public UserDTO(Integer uid, String username, String password, Set<Product> product) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.product = product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
    
    public UserDTO(){}

    public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public UserDTO(String uname, String pass) {
        this.username=uname;
        this.password=pass;
    }

    public UserDTO(String uname, String pass, Integer id) {
        this.username = uname;
        this.password = pass;
        this.uid = id;
    }


    @Override
    public String toString() {
        return "User [id=" + uid + ", pass=" + password + ", uname=" + username + "]";
    }

}