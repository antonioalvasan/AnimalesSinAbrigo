package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.AdopterUserInfoWindow;
import org.is2.asa.view.windowClass;

public class AdopterUserInfoWindowBuilder extends windowBuilder {
    public final static String code = "AUIW";

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new AdopterUserInfoWindow(adopterController) : null;
    }
}
