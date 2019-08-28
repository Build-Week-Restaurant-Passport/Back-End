package com.lambda.restaurant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "newuser")
public class NewUse {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long userid;

@Column(nullable = false,
        unique = true)
private String email;

@Column(nullable = false)
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private String password;

    public NewUse() {
    }

    public NewUse(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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
