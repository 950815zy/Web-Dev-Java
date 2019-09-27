package com.itlize.project2.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * User
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @GenericGenerator(name="asc_gen", strategy = "increment")
    @GeneratedValue(generator = "asc_gen")
    // @Column(name = "id")
    Integer uid;
    
    // @Column(name = "uname", nullable = false)
    String username;

    // @Column(name = "pass", nullable = false)
    String password;

    // @Column(name = "register_date", nullable = true)

    public User(){}

    public User(String uname, String pass) {
        this.username=uname;
        this.password=pass;
    }

    public User(String uname, String pass, Integer id) {
        this.username = uname;
        this.password = pass;
        this.uid = id;
    }

    public String getUname() {
        return username;
    }

    public void setUname(String uname) {
        this.username = uname;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    public Integer getId() {
        return uid;
    }

    public void setId(Integer id) {
        this.uid = id;
    }


    @Override
    public String toString() {
        return "User [id=" + uid + ", pass=" + password + ", uname=" + username + "]";
    }

}