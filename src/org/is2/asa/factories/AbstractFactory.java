package org.is2.asa.factories;

import org.json.JSONObject;

public abstract class AbstractFactory <T>{

    public T generateObject(JSONObject info){
        T newObject = createInstance(info);
        return newObject;
    }

    abstract T createInstance(JSONObject info);
}
