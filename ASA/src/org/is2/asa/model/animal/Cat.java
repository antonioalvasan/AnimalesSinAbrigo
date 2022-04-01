package org.is2.asa.model.animal;

public class Cat extends Animal{

    public Cat(AnimalType type, String ID, String name, char sex, double weight, boolean alive, boolean adopted) {
        super(AnimalType.CAT, ID, name, sex, weight, alive, adopted);
    }
}
