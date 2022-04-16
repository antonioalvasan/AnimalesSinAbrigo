package org.is2.asa.control;

import org.is2.asa.model.User;
import org.is2.asa.view.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdopterController {

    private final JLabel userLabel;
    private User user;
    private ArrayList<windowClass> viewList;
    private JFrame viewFrame;
    private windowClass currentView;

    public AdopterController(@NotNull User user) {
        this.user = user;
        this.userLabel = new JLabel(user.getUsername());
        this.viewFrame = new JFrame();

        this.viewList = new ArrayList<>();
        viewList.add(new AdopterHomeWindow(this));
        viewList.add(new AdopterUserInfoWindow(this));
        viewList.add(new AdopterUserInfoWindow2(this));
        viewList.add(new SecondaryAdoptionWindow1(this));
        viewList.add(new SecondaryAdoptionWindow2(this));

        currentView = viewList.get(0);
    }

    private @NotNull windowClass findView(String key) throws IllegalArgumentException{
        for(windowClass w : viewList)
            if(w.equalsKey(key))
                return w;
        throw new IllegalArgumentException("view not found in viewList");
    }

    public void changeWindow(String key){
        windowClass w = new AdopterHomeWindow(this);
        try {
            w = findView(key);
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        currentView = w;
        viewFrame.getContentPane().removeAll();
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



