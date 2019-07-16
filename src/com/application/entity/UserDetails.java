package com.application.entity;

import javax.persistence.*;


@Entity
@NamedQuery(name="UserDetails.byId",query="from UserDetails where id =:userId")
@NamedNativeQuery(name="UserDetails.byName",query="SELECT  * FROM userdetails WHERE username = :userName",resultClass = UserDetails.class)

public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
