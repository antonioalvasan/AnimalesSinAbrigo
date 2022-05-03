package org.is2.asa.model;

import org.json.JSONObject;

public class Dog extends Animal{

    DogRace race;

    public Dog(int linkedUser, String name, int age, double weight, String description, DogRace race) {
        super(linkedUser, name, age, weight, description,race.getImageLink());
        this.race = race;
    }

    public Dog(int identifier, int linkedUser, String name, int age, double weight, String description, DogRace race,
               String img, int originalRefuge, String state) {
        super(identifier, linkedUser, name, age, weight, description, img, originalRefuge, state);
        this.race = race;
    }

    @Override
    public String getRace() {
        return this.race.DisplayName();
    }

    public void setRace(DogRace race) {
        this.race = race;
    }

    public String getSpecies(){
        return Species.DOG.DisplayName();
    }

    @Override
    public JSONObject toJson(){
        JSONObject dog = new JSONObject();
        dog.put("species", "DOG");

        JSONObject data = new JSONObject();
        data.put("race", race.toString());
        data.put("identifier", getIdentifier());
        data.put("linkedUser", getLinkedUser());
        data.put("name", getName());
        data.put("age", getAge());
        data.put("weight", getWeight());
        data.put("description", getDescription());
        data.put("img", getImg());
        data.put("state", getState().toString());
        data.put("originalRefuge", getOriginalRefuge());
        dog.put("data", data);

        return dog;
    }
}
