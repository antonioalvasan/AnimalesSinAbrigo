package org.is2.asa.factories;

import org.is2.asa.model.*;
import org.json.JSONObject;

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

        DogRace race = DogRace.valueOf(dogData.getString("race"));
        int ID = dogData.getInt("identifier");
        int linkedUser = dogData.getInt("linkedUser");
        String name = dogData.getString("name");
        int age = dogData.getInt("age");
        double weight = dogData.getDouble("weight");
        String desc = dogData.getString("description");

        return new Dog(ID, linkedUser, name, age, weight, desc, race);
    }

    private Animal CreateCat(JSONObject catData) {
        CatRace race = CatRace.valueOf(catData.getString("race"));
        int ID = catData.getInt("identifier");
        int linkedUser = catData.getInt("linkedUser");
        String name = catData.getString("name");
        int age = catData.getInt("age");
        double weight = catData.getDouble("weight");
        String desc = catData.getString("description");

        return new Cat(ID, linkedUser, name, age, weight, desc, race);
    }
}
