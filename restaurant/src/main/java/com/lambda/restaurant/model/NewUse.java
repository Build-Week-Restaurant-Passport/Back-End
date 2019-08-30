package com.lambda.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "newuser")
public class NewUse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false,
            unique = false)
    private String fname;

    @Column(nullable = false,
            unique = false)
    private String lname;


    @Column(nullable = false,
        unique = true)
    private String email;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

//    @OneToMany(mappedBy = "user",
//            cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("user")
//    private List userRoles = new ArrayList<>();




    public NewUse() {
    }




    public NewUse(String fname, String lname, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        setPassword(password);
//        List userRoles = new ArrayList();
//        userRoles.add(getAuthority());
        getAuthority();
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public void setPasswordNoEncrypt(String password)
    {
        this.password = password;
    }
//

//    public String getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(String userRole) {
//        this.userRole = userRole;
//    }

    //
    public List<SimpleGrantedAuthority> getAuthority()
    {

        List<SimpleGrantedAuthority> rtnList = new ArrayList<>();

//        for (UserRoles r : this.userRoles)
//        {
//            String myRole = "ROLE_" + r.getRole().getName().toUpperCase();
        rtnList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }

        return rtnList;
    }

//    public List getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(List userRoles) {
//        this.userRoles = userRoles;
//    }
}
