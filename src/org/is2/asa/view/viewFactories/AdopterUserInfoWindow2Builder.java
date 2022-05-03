package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.AdopterUserInfoWindow2;
import org.is2.asa.view.windowClass;

//Builder design pattern used
public class AdopterUserInfoWindow2Builder  extends windowBuilder {
    public final static String code = AdopterUserInfoWindow2.key;

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new AdopterUserInfoWindow2(adopterController) : null;
    }
}
