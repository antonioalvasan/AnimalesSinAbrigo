package org.is2.asa.control;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

import javax.swing.*;

public class RefugeeController {

    private User loggedUser; //actual log in user
    private UserDao userDao; //

    public RefugeeController(User user) {
        this.loggedUser = user;


    }

}
