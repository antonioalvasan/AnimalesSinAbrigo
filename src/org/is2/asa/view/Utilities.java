package org.is2.asa.view;

import javax.swing.*;

public class Utilities {

    public static void setTransparent(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

    }
}
