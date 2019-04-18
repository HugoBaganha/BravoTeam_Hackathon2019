package org.academiadecodigo.bravoteam.persistence.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Component
public class User extends AbstractModel{

    private String userName;
    private String name;
    private String email;
    private int password;

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "user",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private List<Content> contents = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
