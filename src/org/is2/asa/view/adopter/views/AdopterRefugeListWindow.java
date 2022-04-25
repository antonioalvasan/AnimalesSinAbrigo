package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.control.AnimalListController;
import org.is2.asa.control.UserListController;
import org.is2.asa.model.Animal;
import org.is2.asa.model.Role;
import org.is2.asa.model.User;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class AdopterRefugeListWindow extends windowClass {

    public static final String key = "ARLW";
    AnimalListController animalListController;
    UserListController userListController;
    AdopterController adopterController;

    private class refugePanel extends JPanel{

        AnimalListController animalListController;
        User user;

        public refugePanel(User user, AnimalListController animalListController){
            this.animalListController = animalListController;
            this.user = user;
        }

        public void prepare_panel(){

            this.setLayout(new BorderLayout());


            JPanel center = new JPanel();
            center.setBackground(Color.GRAY);
            center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

            JLabel name = new JLabel(user.getName());
            JLabel address = new JLabel(user.getAddress());
            name.setHorizontalAlignment(JLabel.CENTER);
            address.setHorizontalAlignment(JLabel.CENTER);

            center.add(name);
            center.add(address);

            JButton viewAnimals = new JButton("Ver animales de este refugio");

            viewAnimals.addActionListener( e ->{
                //AdopterRefugeListWindow
                JPanel animal_panel = new JPanel();
                animal_panel.setLayout(new BoxLayout(animal_panel, BoxLayout.Y_AXIS));

                ArrayList<Animal> animalList = (ArrayList<Animal>) animalListController.getAll();
                ArrayList<AnimalPanel> animal_panels = new ArrayList<>();

                for(int i =0; i < animalList.size(); i++) {
                    animal_panels.add(new AnimalPanel(animalList.get(i)));
                    animal_panels.get(i).prepare_panel();
                }

            });

            this.add(center, BorderLayout.CENTER);
            this.add(viewAnimals, BorderLayout.EAST);
            this.setBackground(Color.GRAY);

            this.setBorder(BorderFactory.createLineBorder(Color.black));
            this.setPreferredSize(new Dimension(600, 100));
        }


    }

    public AdopterRefugeListWindow(AdopterController adopterController, UserListController userListController, AnimalListController animalListController) {
        super(key);
        this.adopterController = adopterController;
        this.userListController = userListController;
        this.animalListController = animalListController;
    }

    @Override
    public void prepare_panel() {

        this.setLayout(new BorderLayout());

        /**** TOP SECTION  ****/

        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));

        AdopterBar aB = new AdopterBar(adopterController);
        aB.prepare_panel();

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.setBackground(Color.LIGHT_GRAY);

        JTextField searchBar = new JTextField("Search...");
        searchBar.setPreferredSize(new Dimension(300, 20));
        JButton search_button = new JButton("Search");

        searchPanel.add(searchBar);
        searchPanel.add(search_button);

        top.add(aB);
        top.add(searchPanel);


        /**** BOTTOM SECTION ****/

        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));

        ArrayList<User> userList = (ArrayList<User>) userListController.getAll();
        JPanel refugeListPanel = new JPanel();
        refugeListPanel.setLayout(new BoxLayout(refugeListPanel, BoxLayout.Y_AXIS));

        for(User s : userList )
        {
            if(s.getRole() == Role.REFUGE)
            {
                refugePanel p = new refugePanel(s,animalListController);
                p.prepare_panel();
                refugeListPanel.add(p);
            }
        }

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(refugeListPanel);

        this.add(top, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);



        search_button.addActionListener(e ->{
            refugeListPanel.removeAll();
            refugeListPanel.revalidate();
            for(User s : userList )
            {
                if(s.getRole() == Role.REFUGE && s.getName().equals(searchBar.getText()))
                {
                    refugePanel p = new refugePanel(s,animalListController);
                    p.prepare_panel();
                    refugeListPanel.add(p);
                }
            }
            if(refugeListPanel.getComponentCount() == 0)
            {
                JLabel label = new JLabel("[ERROR] REFUGE NOT FOUND");
                label.setFont(new Font("Arial",Font.BOLD,60));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                refugeListPanel.add(label);
                refugeListPanel.setBackground(Color.GRAY);
            }
            refugeListPanel.repaint();
        });
    }
}
