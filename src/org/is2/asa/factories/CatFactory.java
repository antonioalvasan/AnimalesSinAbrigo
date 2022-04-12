package org.is2.asa.factories;

import org.is2.asa.model.Cat;
import org.is2.asa.model.CatRace;
import org.json.JSONObject;

public class CatFactory extends AbstractFactory{

    private CatRace catRace;

    @Override
    Object createInstance(JSONObject info) {

        String species = info.getString("species");

        return new Cat();
    }
}
