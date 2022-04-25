package org.is2.asa.view.adopter.viewFactories;

import org.is2.asa.control.AdopterController;
import org.is2.asa.view.adopter.views.AdopterRefugeListWindow;
import org.is2.asa.view.windowClass;

import java.util.ArrayList;

public class BuilderBasedWindowFactory {

    private final AdopterController adopterController;
    private final ArrayList<windowBuilder> builders;

    public BuilderBasedWindowFactory(AdopterController adopterController){
        this.adopterController = adopterController;
        this.builders = new ArrayList<>();

        builders.add(new AdopterHomeWindowBuilder());
        builders.add(new AdopterUserInfoWindowBuilder());
        builders.add(new AdopterUserInfoWindow2Builder());
        builders.add(new RefugeContactWindowBuilder());
        builders.add(new SecondaryAdoptionWindow1Builder());
        builders.add(new SecondaryAdoptionWindow2Builder());
        builders.add(new AdopterRefugeListWindowBuilder());
        builders.add(new RefugeAnimalListBuilder());
    }

    public windowClass createInstance(String key){
        windowClass x = null;
        for(windowBuilder w : builders)
        {
            x = w.createInstance(key, adopterController);
            if (x != null)
                return x;
        }
        return x;
    }

}
