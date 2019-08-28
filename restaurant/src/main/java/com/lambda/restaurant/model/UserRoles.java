package com.lambda.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "userroles")
public class UserRoles extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("userRoles")
    private User user;

//    @Id
//
//    @JoinColumn(name = "roleid")
//    @JsonIgnoreProperties("userRoles")
//    private String srole;

    @Id
    @ManyToOne
    @JoinColumn(name = "roleid")
   @JsonIgnoreProperties("userRoles")
    private Role role;

    public UserRoles()
    {
    }

//    public UserRoles(User user)
//    {
//        this.user = user;
//    }
//public UserRoles(User user, String srole)
//{
//    this.user = user;
//    this.srole = srole;
//}

    public UserRoles(User user, Role role)
    {
        this.user = user;
        this.role = role;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserRoles))
        {
            return false;
        }
        UserRoles userRoles = (UserRoles) o;
        return getUser().equals(userRoles.getUser()) && getRole().equals(userRoles.getRole());
    }

//    public String getSrole() {
//        return srole;
//    }
//
//    public void setSrole(String srole) {
//        this.srole = srole;
//    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUser(), getRole());
    }
}
