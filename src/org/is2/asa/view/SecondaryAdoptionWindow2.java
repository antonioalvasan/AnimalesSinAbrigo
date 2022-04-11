package org.is2.asa.view;

import javax.swing.*;
import java.awt.*;

public class SecondaryAdoptionWindow2 extends JPanel {

    public void prepare_panel() {

        this.setLayout(new BorderLayout());

        JLabel mensaje = new JLabel("Tu solicitud ha sido enviada con exito");
        mensaje.setBounds(100, 100, 100, 100);

        JPanel panel = new JPanel();
        panel.add(mensaje, BorderLayout.CENTER);

        JButton boton = new JButton("Volver al refugio");
        panel.add(boton, BorderLayout.CENTER);
        panel.setVisible(true);

    }
}