package org.academiadecodigo.bravoteam.services;

import org.academiadecodigo.bravoteam.model.User;

import java.util.List;

public interface UserService {

    User get(Integer id);

    User save(User user);

    List<User> userList();



}
