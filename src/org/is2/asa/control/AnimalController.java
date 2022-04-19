package org.is2.asa.control;

import org.is2.asa.model.Animal;
import org.is2.asa.model.states.AnimalState;

import java.util.ArrayList;

public class AnimalController {

    Animal animal;

    public AnimalController(Animal animal) {
        this.animal = animal;
    }

    public int getId() {
        return animal.getIdentifier();
    }

    public String getName() {
        return animal.getName();
    }

    public int getAge() {
        return animal.getAge();
    }

    public double getWeight() {
        return animal.getWeight();
    }

    public String getDescription() {
        return animal.getDescription();
    }

    public AnimalState getState() {
        return animal.getState();
    }


}
