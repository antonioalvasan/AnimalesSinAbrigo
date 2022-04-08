package org.is2.asa.model;

//State design pattern is used

public abstract class Animal {

    private String identifier;
    private String name;
    private String age;
    private String weight;
    private String description;

    private AnimalState state;

    public Animal(String identifier, String name, String age, String weight, String description) {
        this.identifier = identifier;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.description = description;
        this.state= new NotAdoptedState(this);
    }


    public void changeState(AnimalState state){
        this.state = state;
    }

    public String toString(){
        return state.toString();
    }


}
