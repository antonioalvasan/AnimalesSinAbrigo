package org.is2.asa.view.adopter.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.control.AnimalListController;
import org.is2.asa.control.UserListController;
import org.is2.asa.view.adopter.views.AdopterHomeWindow;
import org.is2.asa.view.adopter.views.AdopterRefugeListWindow;
import org.is2.asa.view.windowClass;

public class AdopterRefugeListWindowBuilder extends windowBuilder {

    public final static String code = AdopterRefugeListWindow.key;

    public windowClass createInstance(String windowCode, AdopterController adopterController, UserListController userListController, AnimalListController animalListController) {
        return (code.equals(windowCode)) ? new AdopterRefugeListWindow(adopterController, userListController, animalListController) : null;
    }



}
