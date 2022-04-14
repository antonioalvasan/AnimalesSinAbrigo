package org.is2.asa.model.states;

//State design pattern is used

import org.is2.asa.model.states.AdoptedState;
import org.is2.asa.model.states.AnimalState;
import org.is2.asa.model.states.NotAdoptedState;

public class AdoptionRequestedState extends AnimalState {

    public AdoptionRequestedState(org.is2.asa.model.Animal animal) {
        super(animal);
    }



    @Override
    public String adoptionRequested() {
        return "adoption already requested";
    }

    @Override
    public String adoptionAccepted() {
        animal.changeState(new AdoptedState(animal));
        return "Adoption successfully adopted";
    }

    @Override
    public String adoptionCancelled() {
        animal.changeState(new NotAdoptedState(animal));
        return "Adoption successfully cancelled";
    }

    @Override
    public String adoptionReturned() {
        return "Error...";
    }

    public String toString(){
        return "Adoption requested";
    }


}
