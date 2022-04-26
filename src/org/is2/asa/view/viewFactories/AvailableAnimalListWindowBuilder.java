package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.AdopterHomeWindow;
import org.is2.asa.view.adopter.views.AvailableAnimalListWindow;
import org.is2.asa.view.viewFactories.windowBuilder;
import org.is2.asa.view.windowClass;

public class AvailableAnimalListWindowBuilder extends windowBuilder {
    public final static String code = AvailableAnimalListWindow.key;

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new AvailableAnimalListWindow(adopterController) : null;
    }

}
