package org.is2.asa.factories;

import org.is2.asa.control.commands.*;
import org.is2.asa.model.Animal;
import org.is2.asa.model.Species;
import org.json.JSONObject;

public abstract class AbstractFactory <T>{

    private Species species;
    private String type;

    public T generateObject(JSONObject info){
        T newObject = createInstance(info);
        return newObject;
    }

    abstract T createInstance(JSONObject info);
}
