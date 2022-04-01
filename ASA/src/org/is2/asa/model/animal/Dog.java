package org.is2.asa.model.animal;

public class Dog extends Animal{
    private boolean PPP;

    public Dog(AnimalType type, String ID, String name, char sex, double weight, boolean alive, boolean adopted, boolean PPP) {
        super(AnimalType.DOG, ID, name, sex, weight, alive, adopted);
        this.PPP=PPP;
    }
}
