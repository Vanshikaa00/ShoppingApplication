package com.caseStudy.eCart.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_login_details")
public class users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long userId;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "active")//, columnDefinition = "int default '1'")
    int active;

    @Column (name = "phno")
    Long phno;

    @Column(name = "fname")
    String fname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Column(name = "lname")
    String lname;

    @Column( name = "role")//, columnDefinition = "int default 'user'")
    String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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


    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

}
