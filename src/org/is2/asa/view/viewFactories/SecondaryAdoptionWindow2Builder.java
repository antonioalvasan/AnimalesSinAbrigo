package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.SecondaryAdoptionWindow2;
import org.is2.asa.view.windowClass;

public class SecondaryAdoptionWindow2Builder extends windowBuilder {
    public final static String code = "SAW2";

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new SecondaryAdoptionWindow2(adopterController) : null;
    }
}