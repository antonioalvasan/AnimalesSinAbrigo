package org.is2.asa.launcher;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

public class Main {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        for(User user : userDao.getAll()){
            System.out.println(user);
        }
    }

}
