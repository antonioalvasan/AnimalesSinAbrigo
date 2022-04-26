package org.is2.asa.view.viewFactories;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Refuge.RefugeHomeWindow;
import org.is2.asa.view.windowClass;

public class RefugeHomeWindowBuilder extends windowBuilder{
    public final static String code = RefugeHomeWindow.key;

    public windowClass createInstance(String windowCode, RefugeController refugeController) {
        return (code.equals(windowCode)) ? new RefugeHomeWindow(refugeController) : null;
    }
}
