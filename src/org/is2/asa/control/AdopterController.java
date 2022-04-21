package org.is2.asa.control;

import org.is2.asa.dao.AnimalDao;
import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;
import org.is2.asa.view.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdopterController {


    private User user;
    private AdopterWindowFactory adopterWindowFactory;
    private UserDao userDao;
    private AnimalListController animalListController;
    private JFrame viewFrame;
    private AdopterWindow currentView;

    public AdopterController(User user, UserDao userDao,AnimalListController animalListController) {
        this.user = user;
        this.viewFrame = new JFrame();
        this.userDao = userDao;
        this.animalListController = animalListController;
        this.adopterWindowFactory = new AdopterWindowFactory(this, userDao, animalListController);
        currentView = adopterWindowFactory.createWindow(AdopterWindowCodes.ADOPTERHOMEWINDOW.getCode());
    }

    public void changeWindow(String key){
        currentView = adopterWindowFactory.createWindow(key);
        viewFrame.getContentPane().removeAll();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getProvince() {
        return user.getProvince();
    }

    public String getAddress(){
        return user.getAddress();
    }

    public String getTlf() {
        return user.getTlf();
    }

    public String getName() {
        return user.getName();
    }

    public String getDescription() {
        return user.getDescription();
    }

    public ImageIcon getIcon() { return user.getImage(); }


    public void changeUserData(String username, String password, String name, String province, String address, String tlf){
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setProvince(province);
        user.setAddress(address);
        user.setTlf(tlf);
    }

    public void run(){
        SwingUtilities.invokeLater((() -> {
            currentView.prepare_panel();
            currentView.setVisible(true);

            viewFrame.setPreferredSize(new Dimension(1300, 600));
            viewFrame.add(currentView);
            viewFrame.pack();
            viewFrame.setVisible(true);
        }));
    }
    }



