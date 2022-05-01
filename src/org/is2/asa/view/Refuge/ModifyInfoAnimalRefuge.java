package org.is2.asa.view.Refuge;



import org.is2.asa.control.RefugeController;
import org.is2.asa.model.Animal;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ModifyInfoAnimalRefuge extends windowClass {
    public final static String key = "MIAR";
    public RefugeController refugeCtrl;
    public ModifyInfoAnimalRefuge(RefugeController ctrl){
        super(key);
        refugeCtrl = ctrl;
    }
    private record Pair(JLabel label, JTextField textField) {

        public JLabel getLabel() {
            return label;
        }

        public JTextField getTextField() {
            return textField;
        }

    }


    public void prepare_panel() {
        this.setLayout(new BorderLayout());

        JPanel change_data_here = new JPanel();
        change_data_here.setLayout(new BoxLayout(change_data_here, BoxLayout.Y_AXIS));

        JLabel modify = new JLabel("<html><body>Modificar datos<br> <body><html>");
        modify.setFont(new Font("Arial",Font.BOLD,30));
        modify.setHorizontalAlignment(JLabel.CENTER);
        modify.setBackground(Color.LIGHT_GRAY);
        modify.setOpaque(true);
        modify.setBorder(BorderFactory.createLineBorder(Color.black));



        JTextField field1= new JTextField();
        field1.setColumns(10);
        field1.setText(Integer.toString(refugeCtrl.getAnimal().getIdentifier()));
      Pair Identifier = new Pair( new JLabel("Identifier:"), field1);

        JTextField field2= new JTextField();
        field2.setColumns(10);
        field2.setText(Integer.toString(refugeCtrl.getAnimal().getLinkedUser()));
       Pair LinkedUser = new Pair( new JLabel("LinkedUser:"),field2);

        JTextField field6= new JTextField();
        field6.setColumns(10);
        field6.setText(refugeCtrl.getAnimal().getName());
      Pair name = new Pair( new JLabel("Name:"),field6);

        JTextField field3= new JTextField();
        field3.setColumns(10);
        field3.setText(Integer.toString(refugeCtrl.getAnimal().getAge()));
       Pair Age = new Pair( new JLabel("Age:"),field3);

        JTextField field4= new JTextField();
        field4.setColumns(10);
        field4.setText(Double.toString(refugeCtrl.getAnimal().getWeight()));
        Pair Weight = new Pair( new JLabel("Weight:"),field4);

        JTextField field5= new JTextField();
        field5.setColumns(10);
        field5.setText(refugeCtrl.getAnimal().getDescription());
        Pair Description = new Pair( new JLabel("Description:"),field5);


        JButton save = new JButton("Save data");
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refugeCtrl.getAnimal().setIdentifier(Integer.parseInt(Identifier.getTextField().getText()));
                refugeCtrl.getAnimal().setLinkedUser(Integer.parseInt(LinkedUser.getTextField().getText()));
                refugeCtrl.getAnimal().setName(name.getTextField().getText());
                refugeCtrl.getAnimal().setAge(Integer.parseInt(Age.getTextField().getText()));
                refugeCtrl.getAnimal().setWeight(Double.parseDouble(Weight.getTextField().getText()));
                refugeCtrl.getAnimal().setDescription( Description.getTextField().getText());

                refugeCtrl.updateanimal(refugeCtrl.getAnimal());

                refugeCtrl.changeWindow(InfoAnimalRefuge.key);
                refugeCtrl.run();

            }



        });
        save.setOpaque(true);
        save.setBackground(Color.LIGHT_GRAY);






        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(Identifier, LinkedUser, name, Age, Weight, Description));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i =0; i < 6; i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            panels.get(i).add(data.get(i).getLabel());
            panels.get(i).add(data.get(i).getTextField());
            change_data_here.add(panels.get(i));
        }

        this.add(modify, BorderLayout.NORTH);
        this.add(change_data_here, BorderLayout.CENTER);
        this.add(save, BorderLayout.SOUTH);

    }

    private void ocultar() {
        this.setVisible(false);
    }


}
