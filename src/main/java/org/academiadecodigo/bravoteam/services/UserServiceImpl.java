package org.academiadecodigo.bravoteam.services;

import org.academiadecodigo.bravoteam.persistence.Dao;
import org.academiadecodigo.bravoteam.persistence.UserDao;
import org.academiadecodigo.bravoteam.persistence.model.Content;
import org.academiadecodigo.bravoteam.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private Content content;

    @Override
    public User get(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Override
    public List<User> userList() {
        return userDao.findAll();
    }

    @Autowired
    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }






}
