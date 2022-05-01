package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.control.RefugeController;
import org.is2.asa.view.Refuge.InfoAnimalRefuge;
import org.is2.asa.view.Refuge.ModifyInfoAnimalRefuge;
import org.is2.asa.view.adopter.views.AdopterUserInfoWindow;
import org.is2.asa.view.windowClass;

public class ModifyInfoAnimalRefugeBuilder extends windowBuilder {
    public final static String code = "MIAR";

    public windowClass createInstance(String windowCode, RefugeController refugeController) {
        return (code.equals(windowCode)) ? new ModifyInfoAnimalRefuge(refugeController) : null;
    }
}