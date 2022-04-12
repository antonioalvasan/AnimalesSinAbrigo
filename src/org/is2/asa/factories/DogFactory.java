package org.is2.asa.factories;

import org.is2.asa.model.Animal;
import org.is2.asa.model.Dog;
import org.json.JSONObject;

public class DogFactory extends AbstractFactory<Animal>{

    @Override
    Animal createInstance(JSONObject info) {



        return new Dog();
    }
}
