package org.is2.asa.model;

//State design pattern is used

public abstract class Animal {

    private int identifier;
    private String name;
    private int age;
    private double weight;
    private String description;
    private final Species species;

    private AnimalState state;

    public Animal(int identifier, String name, int age, double weight, String description, Species species) {
        this.identifier = identifier;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.description = description;
        this.species = species;
        this.state= new NotAdoptedState(this);
    }


    public void changeState(AnimalState state){
        this.state = state;
    }

    public String toString(){
        return state.toString();
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AnimalState getState() {
        return state;
    }



}
