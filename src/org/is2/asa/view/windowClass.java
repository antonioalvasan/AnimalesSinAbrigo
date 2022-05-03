package org.is2.asa.view;

import javax.swing.*;

//MVC design pattern used
public abstract class windowClass extends JPanel {

    private final String key;

    public windowClass(String key){
        this.key = key;
    }

    public abstract void prepare_panel();

    public boolean equalsKey(String s){
        return this.key.equals(s);
    }

}
