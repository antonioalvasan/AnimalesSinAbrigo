package org.is2.asa.control;

import org.is2.asa.dao.AnimalDao;
import org.is2.asa.dao.UserDao;
import org.is2.asa.model.Animal;
import org.is2.asa.model.Role;
import org.is2.asa.model.User;
import org.is2.asa.model.states.NotAdoptedState;
import org.is2.asa.view.*;
import org.is2.asa.view.viewFactories.BuilderBasedWindowFactory;
import org.is2.asa.view.adopter.views.AdopterHomeWindow;
//import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
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
    private final AnimalDao animalDao;
    private final String _usersFile;
    private final String _animalsFile;
    private ArrayList<windowClass> viewList;
    private final JFrame viewFrame;
    private windowClass currentView;
    BuilderBasedWindowFactory builderBasedWindowFactory;
    private User currentRefuge;

    /*
    * ADOPTER CONTROLLER CONSTRUCTOR
    * Parameters: loggedUser, animalDao and userDao.
    * Initializes the frame and the viewList, with every existing AdopterWindow. Sets AdopterHomeWindow as default.
    * */
    public AdopterController(User user, UserDao userDao, AnimalDao animalDao, String usersFile, String animalsFile) {
        this.builderBasedWindowFactory = new BuilderBasedWindowFactory(this, null);
        this.loggedUser = user;
        this.userDao = userDao;
        this.animalDao = animalDao;
        this._usersFile = usersFile;
        this._animalsFile = animalsFile;
        this.currentRefuge = null;
        this.viewFrame = new JFrame();
        prepareFrame();
        currentView = builderBasedWindowFactory.createInstance(AdopterHomeWindow.key);
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
                JPanel topPanel = new JPanel();
                topPanel.setBackground(Color.LIGHT_GRAY);

                JLabel label = new JLabel("Do you want to save data before closing? Data will be overwritten!");
                topPanel.add(label);

                JPanel buttonPanel = new JPanel(new FlowLayout());
                buttonPanel.setBackground(Color.LIGHT_GRAY);
                JButton yesButton = new JButton("Yes");
                JButton noButton = new JButton("No");


                saveDataDialog.add(topPanel, BorderLayout.NORTH);
                buttonPanel.add(yesButton, BorderLayout.WEST);
                buttonPanel.add(noButton, BorderLayout.EAST);
                saveDataDialog.add(buttonPanel, BorderLayout.CENTER);

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
    public void saveData() throws FileNotFoundException {
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
    public int getID() {
        return loggedUser.getID();
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

    public void setCurrentRefuge(User currentRefuge){
        this.currentRefuge = currentRefuge;
    }

    public List<User> getRefuges() {
        List<User> refugesList = new ArrayList<>();

        for(User u : userDao.getAll()){
            if(u.getRole() == Role.REFUGE) refugesList.add(u);
        }

        return refugesList;
    }

    public List<Animal> getAnimalsFromRefuge(){
        List<Animal> availableAnimals = new ArrayList<>();

        for(Animal a: animalDao.getAll()){
            if(a.getLinkedUser() == currentRefuge.getID() && a.getState().toString().equals("Not adopted")){
                availableAnimals.add(a);
            }
        }
        return availableAnimals;
    }

    public List<Animal> getAnimalsOwned() {
        List<Animal> ownedAnimals = new ArrayList<>();

        for(Animal a: animalDao.getAll()){
            if(a.getLinkedUser() == loggedUser.getID() && a.getState().toString().equals("Adopted")){
                ownedAnimals.add(a);
            }
        }
        return ownedAnimals;
    }

    //Cada animal del usuario y que esté adoptado por este usuario vuelve al refugio original con el estado "Not Adopted"
    public void deleteUser() {
        for(int i = 0; i < this.animalDao.getAll().size(); i++){
            if(this.animalDao.get(i).getLinkedUser() == loggedUser.getID()){
                //this.animalDao.delete(this.animalDao.get(i));
                this.animalDao.get(i).changeState(new NotAdoptedState(this.animalDao.get(i)));
                this.animalDao.get(i).setLinkedUser(this.animalDao.get(i).getOriginalRefuge());
            }
        }
        this.userDao.delete(loggedUser);
    }


}



