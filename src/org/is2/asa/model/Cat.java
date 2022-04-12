package org.is2.asa.model;

public class Cat extends Animal{

    CatRace race;

    public Cat(int identifier, int linkedUser, String name, int age, double weight, String description, CatRace race) {
        super(identifier, linkedUser, name, age, weight, description);
        this.race = race;
    }

}
