package org.is2.asa.view.Refuge;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.adopter.views.AdopterUserInfoWindow;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;

public class ModifyAnimalWindow extends windowClass {

    public final static String key = "MAW";
    public RefugeController refugeCtrl;

    public ModifyAnimalWindow(RefugeController ctrl){
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

        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel modify = new JLabel("<html><body>Modificar datos<br> <body><html>");
        modify.setFont(new Font("Arial",Font.BOLD,30));
        modify.setHorizontalAlignment(JLabel.CENTER);
        modify.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e->{
            refugeCtrl.changeWindow(RefugeAnimalsWindow.key);
            refugeCtrl.run();
        });

        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(modify, BorderLayout.CENTER);

        //JTextField to change animals' data.
        JTextField nameField= new JTextField(refugeCtrl.getAnimal().getName());
        nameField.setColumns(10);
        Pair name = new Pair( new JLabel("Name:"),nameField);

        JTextField ageField= new JTextField(Integer.toString(refugeCtrl.getAnimal().getAge()));
        ageField.setColumns(10);
        Pair Age = new Pair( new JLabel("Age:"),ageField);

        JTextField weightField= new JTextField(Double.toString(refugeCtrl.getAnimal().getWeight()));
        weightField.setColumns(10);
        Pair Weight = new Pair( new JLabel("Weight:"),weightField);

        JTextField descField= new JTextField(refugeCtrl.getAnimal().getDescription());
        descField.setColumns(10);
        Pair Description = new Pair( new JLabel("Description:"),descField);

        //Save Button
        JButton save = new JButton("Save data");
        save.addActionListener(e-> {
            refugeCtrl.getAnimal().setName(name.getTextField().getText());
            refugeCtrl.getAnimal().setAge(Integer.parseInt(Age.getTextField().getText()));
            refugeCtrl.getAnimal().setWeight(Double.parseDouble(Weight.getTextField().getText()));
            refugeCtrl.getAnimal().setDescription(Description.getTextField().getText());

            refugeCtrl.updateAnimal(refugeCtrl.getAnimal());

            refugeCtrl.changeWindow(InfoAnimalRefuge.key);
            refugeCtrl.run();
        });

        save.setOpaque(true);
        save.setBackground(Color.LIGHT_GRAY);

        ArrayList<Pair> data = new ArrayList<>(Arrays.asList(name, Age, Weight, Description));
        ArrayList<JPanel> panels = new ArrayList<>();

        for(int i =0; i < data.size(); i++) {
            panels.add(new JPanel(new FlowLayout()));
            panels.get(i).setBackground(Color.GRAY);
            panels.get(i).add(data.get(i).getLabel());
            panels.get(i).add(data.get(i).getTextField());
            change_data_here.add(panels.get(i));
        }

        this.add(topPanel, BorderLayout.NORTH);
        this.add(change_data_here, BorderLayout.CENTER);
        this.add(save, BorderLayout.SOUTH);
    }
}
