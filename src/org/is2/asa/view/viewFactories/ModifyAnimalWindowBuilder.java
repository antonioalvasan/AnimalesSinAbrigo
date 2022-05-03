package org.is2.asa.view.viewFactories;

import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Refuge.ModifyAnimalWindow;
import org.is2.asa.view.windowClass;

//Builder design pattern used
public class ModifyAnimalWindowBuilder extends windowBuilder {
    public final static String code = ModifyAnimalWindow.key;

    public windowClass createInstance(String windowCode, RefugeController refugeController) {
        return (code.equals(windowCode)) ? new org.is2.asa.view.Refuge.ModifyAnimalWindow(refugeController) : null;
    }
}