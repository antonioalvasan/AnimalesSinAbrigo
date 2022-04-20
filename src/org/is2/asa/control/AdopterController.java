package org.is2.asa.control;

import org.is2.asa.model.User;
import org.is2.asa.view.*;
//import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdopterController {

    /*
    * AdopterController Class
    * Pattern -> MVC
    * Part of MVC pattern, this controller is used when an adopter logs into the program
    *
    */

    private User loggedUser;
    private ArrayList<windowClass> viewList;
    private JFrame viewFrame;
    private windowClass currentView;

    /*
    * ADOPTER CONTROLLER CONSTRUCTOR
    * Parameters: loggedUser, animalDao and userDao.
    * Initializes the frame and the viewList, with every existing AdopterWindow. Sets AdopterHomeWindow as default.
    * */
    public AdopterController(User user) {
        this.loggedUser = user;
        this.viewFrame = new JFrame();

        this.viewList = new ArrayList<>();
        viewList.add(new AdopterHomeWindow(this));
        viewList.add(new AdopterUserInfoWindow(this));
        viewList.add(new AdopterUserInfoWindow2(this));
        viewList.add(new SecondaryAdoptionWindow1(this));
        viewList.add(new SecondaryAdoptionWindow2(this));

        currentView = viewList.get(0);
    }

    /*
    * run()
    * Executes the window, preparing it depending on the currentView.
    * */
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

    /*
    * findView(String key)
    * Parameters: String used  to identify window and enable it. Launches IllegalArgumentException
    * if view is not recognized.
    * */
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

    /*
    * Getters, used by windows to obtain user and animal data.
    * */
    public String getUsername() {
        return loggedUser.getUsername();
    }

    public String getPassword() {
        return loggedUser.getPassword();
    }

    public String getProvince() {
        return loggedUser.getProvince();
    }

    public String getAddress(){
        return loggedUser.getAddress();
    }

    public String getTlf() {
        return loggedUser.getTlf();
    }

    public String getName() {
        return loggedUser.getName();
    }

    public String getDescription() {
        return loggedUser.getDescription();
    }
}



