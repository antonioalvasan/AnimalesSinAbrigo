package org.is2.asa.control;

import org.is2.asa.model.User;
import org.is2.asa.view.AdopterWindow;
import org.is2.asa.view.AnimalPanel;

import javax.swing.*;

public class AdopterController {

    private JLabel userLabel;
    User user;

    public AdopterController(User user) {
        this.user = user;
        this.userLabel = new JLabel(user.getUsername());

    }

    public JLabel getUserLabel() {
        return userLabel;
    }




}
