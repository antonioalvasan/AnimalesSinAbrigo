package org.is2.asa.model.animal;

public abstract class Animal {
    private AnimalType type;
    private String ID;
    private String name;
    private char sex; //m or f
    private double weight;
    private boolean alive;
    private boolean adopted;

    public Animal(AnimalType type, String ID, String name, char sex, double weight, boolean alive, boolean adopted) {
        this.type = type;
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.alive = alive;
        this.adopted = adopted;
    }
}
