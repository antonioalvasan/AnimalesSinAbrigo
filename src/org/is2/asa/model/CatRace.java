package org.is2.asa.model;


//Cambiar...
public enum CatRace {
    PERSIAN("Persian","resources/images/animals/cats/persian.png"),
    SIAMES ("Siames","resources/images/animals/cats/siames.jpg"),
    SPHYNX ("Sphynx","resources/images/animals/cats/sphynx.jpg"),
    AKITA ("Akita","resources/images/dogs/goldenRetriever1.jpg");



    private String displayName;
    private String hola;

    CatRace(String displayName, String hola){
        this.displayName = displayName;
        this.hola= hola;
    }

    public String DisplayName(){
        return displayName;
    }
    public String getImageLink(){return hola;}
}
