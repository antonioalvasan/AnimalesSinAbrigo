package org.is2.asa.view.viewFactories;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Refuge.RefugeRequestWindow;
import org.is2.asa.view.windowClass;

//Builder design pattern used
public class RefugeRequestWindowBuilder extends windowBuilder{
    public final static String code = RefugeRequestWindow.key;

    public windowClass createInstance(String windowCode, RefugeController refugeController) {
        return (code.equals(windowCode)) ? new RefugeRequestWindow(refugeController) : null;
    }
}
