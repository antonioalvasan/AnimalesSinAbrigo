package org.is2.asa.view;

import javax.swing.*;

public class Utilities {

    public static void setTransparent(JButton boton) {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }
}
