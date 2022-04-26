package org.is2.asa.view.viewFactories;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Refuge.RefugeHomeWindow;
import org.is2.asa.view.Refuge.RefugeInfoWindow;
import org.is2.asa.view.windowClass;

public class RefugeInfoWindowBuilder extends windowBuilder{
    public final static String code = RefugeInfoWindow.key;

    public windowClass createInstance(String windowCode, RefugeController refugeController) {
        return (code.equals(windowCode)) ? new RefugeInfoWindow(refugeController) : null;
    }
}
