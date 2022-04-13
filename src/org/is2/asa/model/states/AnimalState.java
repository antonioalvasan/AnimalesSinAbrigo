package org.is2.asa.model.states;
import org.is2.asa.model.Animal;

//State design pattern is used

public abstract class AnimalState {

    Animal animal;

    AnimalState(Animal animal){
        this.animal = animal;
    }


    public abstract String adoptionRequested();
    public abstract String adoptionAccepted();
    public abstract String adoptionCancelled();
    public abstract String adoptionReturned();

    //Es para debug
    public abstract String toString();

}
