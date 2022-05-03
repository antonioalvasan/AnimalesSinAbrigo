package org.is2.asa.model;


//Enum for Cat razes
public enum CatRace {
    PERSIAN("Persian"),
    SIAMES ("Siames"),
    SPHYNX ("Sphynx"),
    AKITA ("Akita");



    private String displayName;

    CatRace(String displayName){
        this.displayName = displayName;
    }

    public String DisplayName(){
        return displayName;
    }
}
