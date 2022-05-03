package org.is2.asa.view.viewFactories;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Refuge.RefugeModifyWindow;
import org.is2.asa.view.windowClass;

//Builder design pattern used
public class RefugeModifyWindowBuilder extends windowBuilder{
    public final static String code = RefugeModifyWindow.key;

    public windowClass createInstance(String windowCode, RefugeController refugeController) {
        return (code.equals(windowCode)) ? new RefugeModifyWindow(refugeController) : null;
    }
}
