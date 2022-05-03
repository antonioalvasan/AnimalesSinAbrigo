package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.AdopterAnimalsWindow;
import org.is2.asa.view.windowClass;

//Builder design pattern used
public class AdopterAnimalsWindowBuilder extends windowBuilder{

    public final static String code = AdopterAnimalsWindow.key;

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new AdopterAnimalsWindow(adopterController) : null;
    }

}
