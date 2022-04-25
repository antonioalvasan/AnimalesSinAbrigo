package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.windowClass;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;


public class RefugeContactWindow extends windowClass {

    public static final String keyCode = "RCW";
    private AdopterController adopterController;

    public RefugeContactWindow(AdopterController adopterController) {
        super(keyCode);
        this.adopterController = adopterController;
    }

    private static class Pair {
        private final JLabel first;
        private final JLabel second;

        public Pair(JLabel first, JLabel second) {
            this.first = first;
            this.second = second;
        }

        public JLabel getFirst() {
            return first;
        }

        public JLabel getSecond() {
            return second;
        }

    }

    public void prepare_panel() {
        this.setLayout(new BorderLayout());

        JLabel top_message = new JLabel("¡Contacta con nosotros!");
        top_message.setFont(new Font("Arial", Font.BOLD, 50));
        top_message.setHorizontalAlignment(JLabel.CENTER);

        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(Color.LIGHT_GRAY);
        top.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        top.add(top_message, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(Color.GRAY);
        bottom.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel data_text = new JLabel("Nuestra info");
        data_text.setFont(new Font("Arial", Font.BOLD, 20));
        data_text.setHorizontalAlignment(JLabel.CENTER);

        Pair province = new Pair(new JLabel("Provincia:"), new JLabel("Valladolid"));
        Pair address = new Pair(new JLabel("Dirección:"), new JLabel("Av. Mundial 82, s/n, 47014 Valladolid"));
        Pair tlf = new Pair(new JLabel("Número de teléfono:"), new JLabel("633 33 33 33"));

        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(province, address, tlf));
        ArrayList<JPanel> panels = new ArrayList<>();
        JPanel info_panel = new JPanel();
        info_panel.setLayout(new BoxLayout(info_panel, BoxLayout.Y_AXIS));

        for(int i =0; i < data.size(); i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            data.get(i).getFirst().setFont(new Font("Arial", Font.BOLD, 25));
            data.get(i).getSecond().setFont(new Font("Arial", Font.BOLD, 25));
            panels.get(i).add(data.get(i).getFirst());
            panels.get(i).add(data.get(i).getSecond());
            info_panel.add(panels.get(i));
        }

        bottom.add(info_panel, BorderLayout.CENTER);

        JButton return_button = new JButton("Volver al refugio");
        return_button.setFont(new Font("Arial", Font.BOLD, 25));
        return_button.setBackground(Color.LIGHT_GRAY);

        bottom.add(return_button, BorderLayout.SOUTH);

        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.CENTER);


    }

}
