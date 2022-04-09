package org.is2.asa.model;

public class Dog extends Animal{

    public Dog(int identifier, String name, int age, double weight, String description, DogRace race) {
        super(identifier, name, age, weight, description);
        this.race = race;
    }
}
