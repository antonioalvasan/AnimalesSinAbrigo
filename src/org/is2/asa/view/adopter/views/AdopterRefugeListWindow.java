package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.model.Role;
import org.is2.asa.model.User;
import org.is2.asa.view.adopter.AdopterWindowCodes;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.*;

public class AdopterRefugeListWindow extends windowClass {

    public static final String key = "ARLW";
    AdopterController adopterController;

    private class refugePanel extends JPanel{

        private User user;

        public refugePanel(User user){
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

            viewAnimals.addActionListener(e ->{

            });

            this.add(center, BorderLayout.CENTER);
            this.add(viewAnimals, BorderLayout.EAST);
            this.setBackground(Color.GRAY);

            this.setBorder(BorderFactory.createLineBorder(Color.black));
            this.setPreferredSize(new Dimension(600, 100));
        }


    }

    public AdopterRefugeListWindow(AdopterController adopterController) {
        super(key);
        this.adopterController = adopterController;
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

        ArrayList<User> userList = (ArrayList<User>) adopterController.getUsers();
        JPanel refugeListPanel = new JPanel();
        refugeListPanel.setLayout(new BoxLayout(refugeListPanel, BoxLayout.Y_AXIS));

        for(User s : userList )
        {
            if(s.getRole() == Role.REFUGE)
            {
                refugePanel p = new refugePanel(s);
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
                    refugePanel p = new refugePanel(s);
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
