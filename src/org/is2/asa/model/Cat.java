package org.is2.asa.model;

import org.json.JSONObject;

public class Cat extends Animal{

    CatRace race;

    public Cat(int linkedUser, String name, int age, double weight, String description, CatRace race) {
        super(linkedUser, name, age, weight, description, race.getImageLink());
        this.race = race;
    }

    public Cat(int identifier, int linkedUser, String name, int age, double weight, String description, CatRace race,
               String img, int originalRefuge, String state) {
        super(identifier, linkedUser, name, age, weight, description, img, originalRefuge, state);
        this.race = race;
    }

    @Override
    public String getRace() {
        return this.race.DisplayName();
    }

    public void setRace(CatRace race) {
        this.race = race;
    }

    public String getSpecies(){
        return Species.CAT.DisplayName();
    }

    @Override
    public JSONObject toJson(){
        JSONObject cat = new JSONObject();
        cat.put("species", "CAT");

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
        cat.put("data", data);

        return cat;
    }
}
