package org.is2.asa.model;

//State design pattern is used

import org.is2.asa.model.states.AdoptedState;
import org.is2.asa.model.states.AdoptionRequestedState;
import org.is2.asa.model.states.AnimalState;
import org.is2.asa.model.states.NotAdoptedState;
import org.json.JSONObject;

public abstract class Animal {

    private int identifier;
    private int linkedUser;
    private String name;
    private int age;
    private double weight;
    private String description;
    private String img;
    private int originalRefuge;
    private AnimalState state;

    public Animal(int identifier, int linkedUser, String name, int age, double weight, String description, String img,
                  int orginalRefuge, String state) {
        this.identifier = identifier;
        this.linkedUser = linkedUser;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.description = description;

        if(state.equals("Not adopted")) this.state = new NotAdoptedState(this);
        else if(state.equals("Adopted")) this.state = new AdoptedState(this);
        else if(state.equals("Adoption requested")) this.state = new AdoptionRequestedState(this);

        this.img = img;
        this.originalRefuge = orginalRefuge;
    }

    public Animal(int identifier, int linkedUser, String name, int age, double weight, String description, String img) {
        this.identifier = identifier;
        this.linkedUser = linkedUser;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.description = description;
        this.state= new NotAdoptedState(this);
        this.img = img;
        this.originalRefuge = linkedUser;
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

    public int getLinkedUser() {
        return linkedUser;
    }

    public void setLinkedUser(int linkedUser) {
        this.linkedUser = linkedUser;
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

    public AnimalState getState() { return state; }

    public String getImg() { return img; }
    
    public void setImg(String img) { this.img = img; }

    public String getRace(){
        return null;
    }

    public int getOriginalRefuge() {
        return originalRefuge;
    }

    public abstract String getSpecies();

    public abstract JSONObject toJson();
}
