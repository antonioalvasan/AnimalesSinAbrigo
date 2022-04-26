package org.is2.asa.view.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.control.RefugeController;
import org.is2.asa.view.windowClass;

import java.util.ArrayList;

public class BuilderBasedWindowFactory {

    private final AdopterController adopterCtrl;
    private final RefugeController refugeCtrl;
    private final ArrayList<windowBuilder> builders;

    public BuilderBasedWindowFactory(AdopterController adopterController, RefugeController refugeController){
        this.adopterCtrl = adopterController;
        this.refugeCtrl = refugeController;
        this.builders = new ArrayList<>();

        //Adding Adopter Builders
        builders.add(new AdopterHomeWindowBuilder());
        builders.add(new AdopterUserInfoWindowBuilder());
        builders.add(new AdopterUserInfoWindow2Builder());
        builders.add(new RefugeContactWindowBuilder());
        builders.add(new SecondaryAdoptionWindow1Builder());
        builders.add(new SecondaryAdoptionWindow2Builder());
        builders.add(new AdopterRefugeListWindowBuilder());
        builders.add(new AvailableAnimalListWindowBuilder());

        //Adding Refuge Builders
        builders.add(new RefugeHomeWindowBuilder());
        builders.add(new RefugeInfoWindowBuilder());
        builders.add(new RefugeModifyWindowBuilder());
        builders.add(new RefugeRequestWindowBuilder());
    }

    public windowClass createInstance(String key){
        windowClass x = null;
        for(windowBuilder w : builders)
        {
            x = w.createInstance(key, adopterCtrl);
            if (x != null) return x;
            x = w.createInstance(key, refugeCtrl);
            if (x != null) return x;
        }
        return x;
    }

}
