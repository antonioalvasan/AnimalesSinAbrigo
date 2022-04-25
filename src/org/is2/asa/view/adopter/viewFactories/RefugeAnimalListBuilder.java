package org.is2.asa.view.adopter.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.AdopterHomeWindow;
import org.is2.asa.view.adopter.views.RefugeAnimalList;
import org.is2.asa.view.windowClass;

public class RefugeAnimalListBuilder extends windowBuilder {
    public final static String code = RefugeAnimalList.key;

    public windowClass createInstance(String windowCode, AdopterController adopterController) {
        return (code.equals(windowCode)) ? new RefugeAnimalList(adopterController) : null;
    }
}
