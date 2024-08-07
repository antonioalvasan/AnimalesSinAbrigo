package org.is2.asa.factories;

import org.is2.asa.model.*;
import org.json.JSONObject;

//Factory design pattern is used

//Animal generator factory
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

    //creating a dog
    private Animal CreateDog(JSONObject dogData) {

        DogRace race = DogRace.valueOf(dogData.getString("race"));
        int ID = dogData.getInt("identifier");
        int linkedUser = dogData.getInt("linkedUser");
        String name = dogData.getString("name");
        int age = dogData.getInt("age");
        double weight = dogData.getDouble("weight");
        String desc = dogData.getString("description");
        String img = dogData.getString("img");
        int originalRefuge = dogData.getInt("originalRefuge");
        String state = dogData.getString("state");

        return new Dog(ID, linkedUser, name, age, weight, desc, race, img, originalRefuge, state);
    }

    //creating a cat
    private Animal CreateCat(JSONObject catData) {
        CatRace race = CatRace.valueOf(catData.getString("race"));
        int ID = catData.getInt("identifier");
        int linkedUser = catData.getInt("linkedUser");
        String name = catData.getString("name");
        int age = catData.getInt("age");
        double weight = catData.getDouble("weight");
        String desc = catData.getString("description");
        String img = catData.getString("img");
        int originalRefuge = catData.getInt("originalRefuge");
        String state = catData.getString("state");

        return new Cat(ID, linkedUser, name, age, weight, desc, race, img, originalRefuge, state);
    }
}
