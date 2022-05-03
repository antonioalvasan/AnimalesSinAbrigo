package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.AdopterHomeWindow;
import org.is2.asa.view.windowClass;

//Builder design pattern used
public class AdopterHomeWindowBuilder extends windowBuilder {
    public final static String code = AdopterHomeWindow.key;

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new AdopterHomeWindow(adopterController) : null;
    }
}
