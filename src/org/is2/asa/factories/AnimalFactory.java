package org.is2.asa.factories;

import org.is2.asa.model.*;
import org.json.JSONObject;

import java.util.Objects;

public class AnimalFactory extends AbstractFactory<Animal>{


    @Override
    Animal createInstance(JSONObject info) {

        String specie = info.getString("species");

        if(specie.equals("CAT")){
            return CreateCat(info.getJSONObject("data"));
        }
        else if(specie.equals("DOG")){
            return CreateDog(info.getJSONObject("data"));
        }

        return null;
    }

    private Animal CreateDog(JSONObject dogData) {

        DogRace race = DogRace.valueOf(dogData.getString("Race"));
        int ID = dogData.getInt("Identifier");
        int linkedUser = dogData.getInt("LinkedUser");
        String name = dogData.getString("Name");
        int age = dogData.getInt("Age");
        double weight = dogData.getDouble("Weight");
        String desc = dogData.getString("Descrption");

        return new Dog(ID, linkedUser, name, age, weight, desc, race);
    }

    private Animal CreateCat(JSONObject catData) {
        CatRace race = CatRace.valueOf(catData.getString("Race"));
        int ID = catData.getInt("Identifier");
        int linkedUser = catData.getInt("LinkedUser");
        String name = catData.getString("Name");
        int age = catData.getInt("Age");
        double weight = catData.getDouble("Weight");
        String desc = catData.getString("Descrption");

        return new Cat(ID, linkedUser, name, age, weight, desc, race);
    }
}
