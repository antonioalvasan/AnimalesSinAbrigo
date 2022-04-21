package org.is2.asa.model;

public class Cat extends Animal{

    CatRace race;

    public Cat(int identifier, int linkedUser, String name, int age, double weight, String description, CatRace race,
               String img) {
        super(identifier, linkedUser, name, age, weight, description, img);
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
}
