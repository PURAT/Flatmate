package com.company.flatmate.entity;

import javax.persistence.*;

@Entity
@Table(name="USER_T")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="USERNAME", nullable = false)
    private String username;

    @Column(name="FIRSTNAME", nullable = false)
    private String firstname;


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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
