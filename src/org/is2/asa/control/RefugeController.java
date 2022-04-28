package org.is2.asa.control;

import org.is2.asa.dao.AnimalDao;
import org.is2.asa.dao.UserDao;
import org.is2.asa.model.*;
import org.is2.asa.view.Refuge.RefugeHomeWindow;
import org.is2.asa.view.viewFactories.BuilderBasedWindowFactory;
import org.is2.asa.view.windowClass;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class RefugeController extends JFrame {

    //Dao Info
    private UserDao userDao;
    private AnimalDao animalDao;

    //Files info
    private String usersFile;
    private String animalsFile;

    //LoggedUser info
    private User loggedUser;

    //Frame and windows info
    private final JFrame viewFrame; //Global Frame. Is always visible.
    private windowClass currentView; //Panel visible inside frame. It changes depending on the window.
    BuilderBasedWindowFactory builderBasedWindowFactory;

    public RefugeController(User user, UserDao userDao, AnimalDao animalDao, String usersFile, String animalsFile) {
        this.loggedUser = user;
        this.userDao = userDao;
        this.animalDao = animalDao;
        this.usersFile = usersFile;
        this.animalsFile = animalsFile;
        this.builderBasedWindowFactory = new BuilderBasedWindowFactory(null, this);
        this.viewFrame = new JFrame();
        prepareFrame();

        currentView = builderBasedWindowFactory.createInstance(RefugeHomeWindow.key);
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
     * prepareFrame() function
     * This functions prepares the window behaviour. When closing, it appears a dialog to choose whether to save
     * data or not. In case of choosing 'yes', the data will overwrite the existing file.
     */
    private void prepareFrame() {
        viewFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                JDialog saveDataDialog = new JDialog();
                JPanel topPanel = new JPanel();
                topPanel.setBackground(Color.lightGray);
                JLabel label = new JLabel("Do you want to save data before closing? Data will be overwritten!");
                topPanel.add(label);

                JPanel buttonPanel = new JPanel(new FlowLayout());
                buttonPanel.setBackground(Color.lightGray);
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
    private void saveData() throws FileNotFoundException {
        OutputStream outUsers = new FileOutputStream(usersFile);
        PrintStream printUsers = new PrintStream(outUsers);
        printUsers.print(userDao.storeAsJSON());

        OutputStream outAnimals = new FileOutputStream(animalsFile);
        PrintStream printAnimals = new PrintStream(outAnimals);
        printAnimals.print(animalDao.storeAsJSON());
    }

    public void changeWindow(String key) {
        currentView = builderBasedWindowFactory.createInstance(key);
        viewFrame.getContentPane().removeAll();
    }

    public void changeUserData(String username, String password, String name, String province,
                               String address, String tlf) {
        loggedUser.setUsername(username);
        loggedUser.setPassword(password);
        loggedUser.setName(name);
        loggedUser.setProvince(province);
        loggedUser.setAddress(address);
        loggedUser.setTlf(tlf);
    }

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

    public void createAnimal(String name, String age, String weight, String specie, String race, String desc) {
        int id = animalDao.getAll().size() + 1;

        if(specie.equals("DOG")){
            Dog newDog = new Dog(id, loggedUser.getID(), name, Integer.parseInt(age),
                    Double.parseDouble(weight), specie, DogRace.valueOf(race), desc);
            animalDao.add(newDog);
        }
        else if(specie.equals("CAT")){
            Cat newCat = new Cat(id, loggedUser.getID(), name, Integer.parseInt(age),
                    Double.parseDouble(weight), specie, CatRace.valueOf(race), desc);
            animalDao.add(newCat);
        }
        else{
            System.out.println("[ERROR] Can't identify this specie.");
        }
    }

    public List<Animal> getRefugeAnimals() {
        List<Animal> refugeAnimals = new ArrayList<>();

        for(Animal a: animalDao.getAll()){
            if(a.getOrginalRefuge() == loggedUser.getID()){
                refugeAnimals.add(a);
            }
        }

        return refugeAnimals;
    }

    public List<Animal> getRequestedAnimals() {
        List<Animal> requestedAnimals = new ArrayList<>();

        for(Animal a: animalDao.getAll()){
            if(a.getOrginalRefuge() == loggedUser.getID() && a.getState().toString().equals("Adoption requested")){
                requestedAnimals.add(a);
            }
        }

        return requestedAnimals;
    }
}
