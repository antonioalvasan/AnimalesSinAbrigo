package org.is2.asa.view;

import javax.swing.*;

public class SecondaryAdoptionWindow1 extends JPanel {

    public void prepare_panel() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Panel superior
        JPanel topPanel = new JPanel();

        JLabel topMessage = new JLabel("¿Quieres adoptar a Toby?");
        topMessage.setBounds(100, 100, 100, 100);

        topPanel.add(topMessage);
        topPanel.setVisible(true);

        //Panel inferior
        JPanel supPanel = new JPanel();

        JLabel supMessage = new JLabel("Datos");
        supMessage.setBounds(100, 100, 100, 100);

        JLabel name = new JLabel("Nombre");
        name.setBounds(100, 100, 100, 100);
        JLabel surname = new JLabel("Apellido");
        surname.setBounds(200, 100, 100, 100);
        JLabel address = new JLabel("Direccion");
        address.setBounds(100, 80, 100, 100);
        JLabel age = new JLabel("Edad");
        age.setBounds(200, 100, 80, 100);
        JLabel curse = new JLabel("Curse");
        curse.setBounds(100, 60, 100, 100);
        JLabel income =  new JLabel("Renta");
        income.setBounds(200, 60, 100, 100);

        JTextField textName = new JTextField();
        JTextField textSurname = new JTextField();
        JTextField textAddress = new JTextField();
        JTextField textAge = new JTextField();

        JComboBox Combocurse = new JComboBox();
        JComboBox Comboincome = new JComboBox();

        JButton supButton = new JButton("Solicitar");
        supPanel.add(supButton);

        supPanel.setVisible(true);
    }

}
