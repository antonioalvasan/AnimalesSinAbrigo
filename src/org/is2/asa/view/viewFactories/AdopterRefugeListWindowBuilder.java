package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.AdopterRefugeListWindow;
import org.is2.asa.view.windowClass;

//Builder design pattern used
public class AdopterRefugeListWindowBuilder extends windowBuilder {

    public final static String code = AdopterRefugeListWindow.key;

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new AdopterRefugeListWindow(adopterController) : null;
    }

}
