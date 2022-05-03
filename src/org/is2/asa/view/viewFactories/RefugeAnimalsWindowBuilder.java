package org.is2.asa.view.viewFactories;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Refuge.RefugeAnimalsWindow;
import org.is2.asa.view.windowClass;

//Builder design pattern used
public class RefugeAnimalsWindowBuilder extends windowBuilder{
    public final static String code = RefugeAnimalsWindow.key;

    public windowClass createInstance(String windowCode, RefugeController refugeController) {
        return (code.equals(windowCode)) ? new RefugeAnimalsWindow(refugeController) : null;
    }
}
