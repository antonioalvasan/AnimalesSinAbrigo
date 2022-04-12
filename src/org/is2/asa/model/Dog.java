package org.is2.asa.model;

public class Dog extends Animal{

    DogRace race;

    public Dog(int identifier, int linkedUser, String name, int age, double weight, String description, DogRace race) {
        super(identifier, linkedUser, name, age, weight, description);
        this.race = race;
    }
}
