package org.is2.asa.control;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

public class RefugeController {

    private User loggedUser; //actual log in user
    private UserDao userDao; //

    public RefugeController(User user) {
        this.loggedUser = user;


    }

}
