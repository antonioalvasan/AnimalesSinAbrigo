package org.is2.asa.model.states;

//State design pattern is used
//All pattern visual resources in resources/patternVisualDocs

public class NotAdoptedState extends AnimalState {

    public NotAdoptedState(org.is2.asa.model.Animal animal) {
        super(animal);
    }

    @Override
    public String adoptionRequested() {
        animal.changeState(new AdoptionRequestedState(animal));
        return "Adoption request sent";
    }

    @Override
    public String adoptionAccepted() {
        return null;
    }

    @Override
    public String adoptionCancelled() {
        return "!Adoption_request ...";
    }

    @Override
    public String adoptionReturned() {
        return "Not adopted...";
    }

    public String toString(){
        return "Not adopted";
    }

}
