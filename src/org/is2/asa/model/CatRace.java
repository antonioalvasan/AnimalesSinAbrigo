package org.is2.asa.model;


//Cambiar...
public enum CatRace {
    BORDER_COLLIE ("Border Collie"),
    ALASKAN_MALAMUTE ("Alaskan Malamute"),
    BULLDOG ("Perro toro"),
    AKITA ("Akita"),
    BULLTERRIER ("Bull Terrier"),
    LABRADOR ("Labrador");


    private String displayName;

    CatRace(String displayName){
        this.displayName = displayName;
    }

    public String DisplayName(){
        return displayName;
    }
}
