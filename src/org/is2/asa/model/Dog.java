package org.is2.asa.model;

public class Dog extends Animal{

    DogRace race;

    public Dog(int identifier, int linkedUser, String name, int age, double weight, String description, DogRace race,
               String img) {
        super(identifier, linkedUser, name, age, weight, description, img);
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
}
