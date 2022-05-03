package org.is2.asa.model.states;

//State design pattern is used
//All pattern visual resources in resources/patternVisualDocs

public class AdoptedState extends AnimalState {

    public AdoptedState(org.is2.asa.model.Animal animal) {
        super(animal);
    }

    @Override
    public String adoptionRequested() {
        return "Animal already adopted";
    }

    @Override
    public String adoptionAccepted() {
        return "Animal already adopted";
    }

    @Override
    public String adoptionCancelled() {
        return "Error...";
    }

    @Override
    public String adoptionReturned() {
        animal.changeState(new NotAdoptedState(animal));
        return "Adoption successfully returned";
    }

    public String toString(){
        return "Adopted";
    }
}
