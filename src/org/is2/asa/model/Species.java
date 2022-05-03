package org.is2.asa.model;

//Species enum
public enum Species {
    DOG("Dog"),
    CAT("Cat");

    private String displayName;

    Species(String displayName){
        this.displayName = displayName;
    }

    public String DisplayName(){
        return displayName;
    }
}
