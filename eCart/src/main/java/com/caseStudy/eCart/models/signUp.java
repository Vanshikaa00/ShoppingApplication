package com.caseStudy.eCart.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sign_up_info")
public class signUp  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;
    @Column(name = "fname")
    String fname;
    @Column(name = "lname")
    String lname;
    @Column(name = "email",unique = true)
    String email;
    @Column(name = "password")
    String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
