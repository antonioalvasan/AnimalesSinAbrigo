package org.is2.asa.control;

import org.is2.asa.model.User;
import org.is2.asa.view.*;
//import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdopterController {


    private User user;
    private ArrayList<windowClass> viewList;
    private JFrame viewFrame;
    private windowClass currentView;

    public AdopterController(User user) {
        this.user = user;
        this.viewFrame = new JFrame();

        this.viewList = new ArrayList<>();
        viewList.add(new AdopterHomeWindow(this));
        viewList.add(new AdopterUserInfoWindow(this));
        viewList.add(new AdopterUserInfoWindow2(this));
        viewList.add(new SecondaryAdoptionWindow1(this));
        viewList.add(new SecondaryAdoptionWindow2(this));

        currentView = viewList.get(0);
    }

    private windowClass findView(String key) throws IllegalArgumentException{
        for(windowClass w : viewList)
            if(w.equalsKey(key))
                return w;
        throw new IllegalArgumentException("view not found in viewList");
    }

    public void changeWindow(String key){
        windowClass w = new AdopterHomeWindow(this);
        try {
            w = findView(key);
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        currentView = w;
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



