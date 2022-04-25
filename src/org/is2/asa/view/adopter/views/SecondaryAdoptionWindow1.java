package org.is2.asa.view.adopter.views;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.windowClass;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class SecondaryAdoptionWindow1 extends windowClass {

    public static final String keyCode = "SAW1";
    AdopterController adopterController;

    public SecondaryAdoptionWindow1(AdopterController adopterController) {
        super(keyCode);
        this.adopterController = adopterController;
    }

    private record Pair(JLabel first, JTextField second){
        public JLabel getLabel() {
            return first;
        }
        public JTextField getTextField() {
            return second;
        }
    }

    public void prepare_panel() {

        this.setLayout(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(Color.LIGHT_GRAY);
        top.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel message = new JLabel("¿Quieres adoptar a Toby?");
        message.setFont(new Font("Arial", Font.BOLD, 40));
        message.setHorizontalAlignment(JLabel.CENTER);

        top.add(message, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(Color.GRAY);
        bottom.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel data_text = new JLabel("Datos");
        data_text.setFont(new Font("Arial", Font.BOLD, 20));
        data_text.setHorizontalAlignment(JLabel.CENTER);

        bottom.add(data_text, BorderLayout.NORTH);

        Pair name = new Pair(new JLabel("Usuario:"), new JTextField("Escribe tu usuario aquí..."));
        Pair surname = new Pair(new JLabel("Contraseña:"), new JPasswordField("Escribe tu contraseña aquí..."));
        Pair province = new Pair(new JLabel("Provincia:"), new JTextField("Escribe tu provincia aquí..."));
        Pair address = new Pair(new JLabel("Direccion:"), new JTextField("Escribe tu dirección aquí..."));
        Pair tlf = new Pair(new JLabel("Número de teléfono:"), new JTextField("Escribe tu número de teléfono aquí..."));
        JLabel request_testL = new JLabel("Texto de peticion:");
        JTextArea request_textA = new JTextArea("\"Escribe tu petición aquí...\"");
        request_textA.setPreferredSize(new Dimension(300,100));

        ArrayList<Pair> dataX = new ArrayList<>(Arrays.asList(name, surname, province, address, tlf));
        ArrayList<JPanel> panels = new ArrayList<>();
        JPanel request_data = new JPanel();
        request_data.setLayout(new BoxLayout(request_data, BoxLayout.Y_AXIS));

        for (int i = 0; i < dataX.size(); i++)
        {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            panels.get(i).add(dataX.get(i).getLabel());
            panels.get(i).add(dataX.get(i).getTextField());
            request_data.add(panels.get(i));
        }

        JPanel p = new JPanel(new FlowLayout());
        p.setBackground(Color.GRAY);
        p.add(request_testL);
        p.add(request_textA);
        request_data.add(p);

        bottom.add(request_data, BorderLayout.CENTER);

        JButton send_button = new JButton("Enviar petición");
        send_button.setFont(new Font("Arial", Font.BOLD, 20));
        send_button.setOpaque(true);
        send_button.setBackground(Color.LIGHT_GRAY);

        bottom.add(send_button, BorderLayout.SOUTH);

        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.CENTER);
        this.setBackground(Color.LIGHT_GRAY);

    }

}
