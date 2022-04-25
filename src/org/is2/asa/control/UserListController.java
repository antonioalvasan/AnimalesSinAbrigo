package org.is2.asa.control;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

import java.util.List;

public class UserListController {

    UserDao userDao;

    public UserListController(UserDao userDao){
        this.userDao=userDao;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

}
