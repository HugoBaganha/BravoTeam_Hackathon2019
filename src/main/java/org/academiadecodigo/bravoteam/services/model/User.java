package org.academiadecodigo.bravoteam.services.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user" )
public class User extends org.academiadecodigo.bravoteam.services.model.AbstractModel {

    private String userName;
    private String name;
    private String email;
    private int password;

    @OneToMany(
            mappedBy = "user",
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )

    private List<Content> accounts = new ArrayList<>();


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
