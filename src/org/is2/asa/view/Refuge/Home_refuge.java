package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;


import javax.swing.*;
import java.awt.*;

public class Home_refuge extends JPanel {
    public RefugeController controladorventanas;
    public Home_refuge(RefugeController ctrl){
        controladorventanas= ctrl;

    }
    public void prepare_panel() {

        this.setLayout(new BorderLayout());

        RefugeBar bar = new RefugeBar(controladorventanas);
        bar.prepare_panel();
        this.add(bar, BorderLayout.NORTH);

        JPanel bottom_panel = new JPanel();
        bottom_panel.setLayout(new BoxLayout(bottom_panel, BoxLayout.Y_AXIS));

        JPanel bottom_panel_0 = new JPanel(new BorderLayout());
        JPanel bottom_panel_1 = new JPanel(new BorderLayout());

        //bottom panel 0

        bottom_panel_0.setBackground(Color.gray);
        bottom_panel_0.setBorder(BorderFactory.createLineBorder(Color.black));


        JLabel title = new JLabel("Animales Sin Abrigo");
        title.setFont(new Font("Arial",Font.BOLD,75));
        title.setHorizontalAlignment(JLabel.CENTER);

        bottom_panel_0.add(title, BorderLayout.CENTER);



        //bottom panel 1
        bottom_panel_1.setBackground(Color.LIGHT_GRAY);

        JLabel description1 = new JLabel("<html><body><br>Bienvenido, Refugio1<body><html>");
        JLabel description2 = new JLabel("<html><body>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                "<br>ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "<br>ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat" +
                "<br>nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim " +
                "<br>id est laborum.<body><html>");

        description1.setFont(new Font("Arial",Font.BOLD,35));
        description1.setHorizontalAlignment(JLabel.CENTER);
        description2.setHorizontalAlignment(JLabel.CENTER);

        bottom_panel_1.add(description1, BorderLayout.NORTH);
        bottom_panel_1.add(description2, BorderLayout.CENTER);


        bottom_panel.add(bottom_panel_0, BorderLayout.CENTER);
        bottom_panel.add(bottom_panel_1, BorderLayout.SOUTH);

        this.add(bottom_panel, BorderLayout.CENTER);

    }


}
