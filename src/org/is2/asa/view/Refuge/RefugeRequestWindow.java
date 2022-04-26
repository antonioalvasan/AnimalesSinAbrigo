package org.is2.asa.view.Refuge;



import org.is2.asa.control.RefugeController;
import org.is2.asa.view.windowClass;

import javax.swing.*;
import java.awt.*;

public class RefugeRequestWindow extends windowClass {
    public static final String key = "RRW";
    public RefugeController refugeCtrl;

    public RefugeRequestWindow(RefugeController ctrl){
        super(key);
        refugeCtrl = ctrl;
    }

    public void prepare_panel() {

        this.setLayout(new BorderLayout());

        RefugeBar bar = new RefugeBar(refugeCtrl);
        bar.prepare_panel();
        this.add(bar, BorderLayout.NORTH);


        JPanel panelcenter= new JPanel();
        panelcenter.setLayout(new BorderLayout());

        JPanel panel_sup1= new JPanel();

        JLabel title = new JLabel("Requests");
        title.setFont(new Font("Arial",Font.BOLD,45));
        title.setHorizontalAlignment(JLabel.CENTER);

        panel_sup1.add(title, BorderLayout.CENTER);



        panel_sup1.setBorder(BorderFactory.createLineBorder(Color.black));

        panel_sup1.setVisible(true);
        panel_sup1.setBackground(Color.LIGHT_GRAY);
        panel_sup1.setBorder(BorderFactory.createLineBorder(Color.black));
        panelcenter.add(panel_sup1,BorderLayout.NORTH);


        JPanel animal_panel = new JPanel();
        animal_panel.setLayout(new BoxLayout(animal_panel, BoxLayout.Y_AXIS));

        //adding animal vector
        String[] names = {"Toby", "Marcelino", "Amadeo", "Juan", "Eneko", "Antonio", "Fabri", "Javi", "Salgueiro"};
        RequestPanel[] request_vector = new RequestPanel[names.length];

        for(int i =0; i < request_vector.length; i++) {
            request_vector[i] = new RequestPanel();
            request_vector[i].prepare_panel(names[i]);
            animal_panel.add(request_vector[i]);

        }

        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(500,300));
        scroll.setViewportView(animal_panel);

        panelcenter.add(scroll,BorderLayout.CENTER);
        panelcenter.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(panelcenter,BorderLayout.CENTER);

    }
}
