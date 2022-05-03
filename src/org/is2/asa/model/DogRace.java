package org.is2.asa.model;

//Enum for Dog razes
public enum DogRace {
    GOLDEN_RETRIEVER ("Golden Retriever"),
    BORDER_COLLIE ("Border Collie"),
    ALASKAN_MALAMUTE ("Alaskan Malamute"),
    BULLDOG ("Perro toro"),
    AKITA ("Akita"),
    BULLTERRIER ("Bull Terrier"),
    LABRADOR ("Labrador");


    private String displayName;

    DogRace(String displayName){
        this.displayName = displayName;
    }

    public String DisplayName(){
        return displayName;
    }

}
