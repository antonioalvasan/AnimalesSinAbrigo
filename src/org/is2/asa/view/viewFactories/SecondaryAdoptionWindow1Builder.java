package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.SecondaryAdoptionWindow1;
import org.is2.asa.view.windowClass;

public class SecondaryAdoptionWindow1Builder extends windowBuilder {
    public final static String code = "SAW1";

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new SecondaryAdoptionWindow1(adopterController) : null;
    }
}
