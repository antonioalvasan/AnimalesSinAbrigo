package org.is2.asa.control;

import org.is2.asa.model.User;
import org.is2.asa.view.Refuge.AnimalsRefuge;
import org.is2.asa.view.Refuge.Home_refuge;
import org.is2.asa.view.Refuge.RefugeInfoWindow;
import org.is2.asa.view.Refuge.RequestRefuge;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RefugeController extends JFrame{
    public Home_refuge homerefuge;
    public AnimalsRefuge animalsrefuge;
    public RefugeInfoWindow infowindow;
    public RequestRefuge requestrefuge;

    public User loggeduser;
    public  JPanel panelvisible;
    public   ArrayList<JPanel> listapantallas;


    public RefugeController(User loggeduser){
        this.loggeduser=loggeduser;
        homerefuge = new Home_refuge(this);
        animalsrefuge= new AnimalsRefuge(this);
        infowindow= new RefugeInfoWindow(this);
        requestrefuge= new RequestRefuge(this);

        homerefuge.prepare_panel();
        animalsrefuge.prepare_panel();
        infowindow.prepare_panel();
        requestrefuge.prepare_panel();
        listapantallas= new ArrayList<>(Arrays.asList(homerefuge,animalsrefuge));

    }
    public void mostrar(String ventana){
        switch(ventana){

            case "Home":
                ocultar();
                homerefuge.setVisible(true);
                panelvisible=homerefuge;
                break;
            case "animals":
               ocultar();
                animalsrefuge.setVisible(true);
                panelvisible=animalsrefuge;
                break;
            case "info":
                ocultar();
                infowindow.setVisible(true);
                panelvisible=infowindow;
                break;
            case "request":
                ocultar();
                requestrefuge.setVisible(true);
                panelvisible= requestrefuge;
        }
        this.getContentPane().removeAll();
        this.getContentPane().add(panelvisible);



        this.setPreferredSize(new Dimension(1300, 600));
         this.pack();
        this.setVisible(true);

    }
    public void ocultar(){
        for(int i=0; i<listapantallas.size();i++){
            listapantallas.get(i).setVisible(false);

        }


    }


}
