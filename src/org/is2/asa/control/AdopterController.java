package org.is2.asa.control;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;
import org.is2.asa.view.*;
import org.is2.asa.view.adopter.AdopterWindowCodes;
import org.is2.asa.view.adopter.viewFactories.BuilderBasedWindowFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class AdopterController {

    /*
    * AdopterController Class
    * Pattern -> MVC
    * Part of MVC pattern, this controller is used when an adopter logs into the program
    *
    */

    private final User loggedUser;
    private final UserDao userDao;
    private ArrayList<windowClass> viewList;
    private final JFrame viewFrame;
    private windowClass currentView;
    private User currentRefuge;
    private AnimalListController animalListController;
    BuilderBasedWindowFactory builderBasedWindowFactory;

    /*
    * ADOPTER CONTROLLER CONSTRUCTOR
    * Parameters: loggedUser, animalDao and userDao.
    * Initializes the frame and the viewList, with every existing AdopterWindow. Sets AdopterHomeWindow as default.
    * */
    public AdopterController(User user, UserDao userDao, AnimalListController animalListController) {
        this.animalListController = animalListController;
        this.builderBasedWindowFactory = new BuilderBasedWindowFactory(this);
        this.loggedUser = user;
        this.userDao = userDao;
        this.currentRefuge = null;
        this.viewFrame = new JFrame();
        prepareFrame();
        currentView = builderBasedWindowFactory.createInstance(AdopterWindowCodes.ADOPTERHOMEWINDOW.getWindowCode());
    }

    public User getCurrentRefuge(){
        return currentRefuge;
    }

    public AnimalListController getAnimalList(){
        return animalListController;
    }

    public void setCurrentRefuge(User currentRefuge){
        this.currentRefuge = currentRefuge;
    }

    private void prepareFrame() {
        viewFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Do what you want when the window is closing.
                JDialog saveData = new JDialog();
                JLabel label = new JLabel("Do you want to save data before closing?");
                JButton yes = new JButton("Yes");
                JButton no = new JButton("No");


                saveData.add(label, BorderLayout.NORTH);
                saveData.add(yes, BorderLayout.WEST);
                saveData.add(no, BorderLayout.EAST);

                yes.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //guardarArchivo();
                        System.exit(0);
                    }
                });

                saveData.setSize(560, 200);
                saveData.setLocationRelativeTo(null);
                saveData.setVisible(true);

            }
        });
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


    public void changeWindow(String key) {
        currentView = builderBasedWindowFactory.createInstance(key);
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

    public List getUsers(){
        return userDao.getAll();
    }

    public void changeUserData(String username, String password, String name, String province, String address, String tlf) {
        loggedUser.setUsername(username);
        loggedUser.setPassword(password);
        loggedUser.setName(name);
        loggedUser.setProvince(province);
        loggedUser.setAddress(address);
        loggedUser.setTlf(tlf);
    }
}



