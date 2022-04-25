package org.is2.asa.view.adopter.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.AdopterUserInfoWindow2;
import org.is2.asa.view.adopter.views.RefugeContactWindow;
import org.is2.asa.view.windowClass;

public class RefugeContactWindowBuilder extends windowBuilder{
    public final static String code = "AUIW2";

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new RefugeContactWindow(adopterController) : null;
    }
}