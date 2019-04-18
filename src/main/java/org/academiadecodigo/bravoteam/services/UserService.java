package org.academiadecodigo.bravoteam.services;

import org.academiadecodigo.bravoteam.services.model.User;

import java.util.List;

public interface UserService {

    User get(Integer id);

    User save(User user);

    List<User> userList();



}
