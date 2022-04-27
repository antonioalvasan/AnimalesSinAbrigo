package org.is2.asa.view.viewFactories;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Refuge.RefugeAddAnimalWindow;
import org.is2.asa.view.windowClass;

public class RefugeAddAnimalWindowBuilder extends windowBuilder{
    public final static String code = RefugeAddAnimalWindow.key;

    public windowClass createInstance(String windowCode, RefugeController refugeController) {
        return (code.equals(windowCode)) ? new RefugeAddAnimalWindow(refugeController) : null;
    }
}
