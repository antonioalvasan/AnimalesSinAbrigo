package org.is2.asa.control;

import org.is2.asa.dao.AnimalDao;
import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;
import org.is2.asa.view.*;
import org.is2.asa.view.adopter.AdopterWindowCodes;
import org.is2.asa.view.adopter.viewFactories.BuilderBasedWindowFactory;
//import org.jetbrains.annotations.NotNull;

import javax.print.attribute.standard.PrinterName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class AdopterController {

    /*
    * AdopterController Class
    * Pattern -> MVC
    * Part of MVC pattern, this controller is used when an adopter logs into the program
    *
    */

    private final User loggedUser;
    private final UserDao userDao;
    private final AnimalDao animalDao;
    private final String _usersFile;
    private final String _animalsFile;
    private ArrayList<windowClass> viewList;
    private final JFrame viewFrame;
    private windowClass currentView;
    BuilderBasedWindowFactory builderBasedWindowFactory;
    private AnimalListController animalListController;
    private User currentRefuge;

    /*
    * ADOPTER CONTROLLER CONSTRUCTOR
    * Parameters: loggedUser, animalDao and userDao.
    * Initializes the frame and the viewList, with every existing AdopterWindow. Sets AdopterHomeWindow as default.
    * */
    public AdopterController(User user, UserDao userDao, AnimalDao animalDao, String usersFile, String animalsFile,
                             AnimalListController animalListController, UserListController userListController) {
        this.builderBasedWindowFactory = new BuilderBasedWindowFactory(this, userListController, animalListController, null);
        this.loggedUser = user;
        this.userDao = userDao;
        this.animalDao = animalDao;
        this._usersFile = usersFile;
        this._animalsFile = animalsFile;
        this.animalListController = animalListController;
        this.currentRefuge = null;
        this.viewFrame = new JFrame();
        prepareFrame();
        currentView = builderBasedWindowFactory.createInstance(AdopterWindowCodes.ADOPTERHOMEWINDOW.getWindowCode());
    }

    /*
    * prepareFrame() function
    * This functions prepares the window behaviour. When closing, it appears a dialog to choose whether to save
    * data or not. In case of choosing 'yes', the data will overwrite the existing file.
    */
    private void prepareFrame() {
        viewFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                JDialog saveDataDialog = new JDialog();
                JLabel label = new JLabel("Do you want to save data before closing? Data will be overwritten!");
                JButton yesButton = new JButton("Yes");
                JButton noButton = new JButton("No");


                saveDataDialog.add(label, BorderLayout.NORTH);
                saveDataDialog.add(yesButton, BorderLayout.WEST);
                saveDataDialog.add(noButton, BorderLayout.EAST);

                yesButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            saveData();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                        System.exit(0);
                    }
                });

                noButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        System.exit(0);
                    }
                });

                saveDataDialog.setSize(560, 200);
                saveDataDialog.setLocationRelativeTo(null);
                saveDataDialog.setVisible(true);

            }
        });
    }

    /*
    * Stores data into the files given as input if the user chooses to do so.
    */
    private void saveData() throws FileNotFoundException {
        OutputStream outUsers = new FileOutputStream(_usersFile);
        PrintStream printUsers = new PrintStream(outUsers);
        printUsers.print(userDao.storeAsJSON());

        OutputStream outAnimals = new FileOutputStream(_animalsFile);
        PrintStream printAnimals = new PrintStream(outAnimals);
        printAnimals.print(animalDao.storeAsJSON());
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

    public ArrayList<User> getUsers(){
        return (ArrayList<User>) userDao.getAll();
    }

    public void changeUserData(String username, String password, String name, String province, String address, String tlf) {
        loggedUser.setUsername(username);
        loggedUser.setPassword(password);
        loggedUser.setName(name);
        loggedUser.setProvince(province);
        loggedUser.setAddress(address);
        loggedUser.setTlf(tlf);
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
}



