package org.is2.asa.control;

import org.is2.asa.model.User;
import org.is2.asa.view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class AdopterController {

    private final JLabel userLabel;
    User user;
    ArrayList<windowClass> viewList;
    JFrame viewFrame;
    windowClass currentView;

    public AdopterController(User user) {
        this.user = user;
        this.userLabel = new JLabel(user.getUsername());
        this.viewFrame = new JFrame();

        this.viewList = new ArrayList<>();
        viewList.add(new AdopterHomeWindow());
        viewList.add(new AdopterUserInfoWindow());
        viewList.add(new AdopterUserInfoWindow2());
        viewList.add(new SecondaryAdoptionWindow1());
        viewList.add(new SecondaryAdoptionWindow2());

        currentView = new AdopterHomeWindow();
    }

    private windowClass findView(String key) throws IllegalArgumentException{
        for(windowClass w : viewList)
            if(w.equalsKey(key))
                return w;

        throw new IllegalArgumentException("view not found in viewList");
    }

    private void changeWindow(String key){
        windowClass w = new AdopterHomeWindow();
        try {
            w = findView(key);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        viewFrame.removeAll();
        viewFrame.revalidate();
        currentView = w;
        viewFrame.repaint();
    }

    public JLabel getUserLabel() {
        return userLabel;
    }

    public void run(){
        SwingUtilities.invokeLater((() -> {
            currentView.prepare_panel();
            currentView.setVisible(true);

            viewFrame.setPreferredSize(new Dimension(1300, 600));
            viewFrame.add(currentView);
            viewFrame.pack();
            viewFrame.setVisible(true);
        }));

    }
    }



