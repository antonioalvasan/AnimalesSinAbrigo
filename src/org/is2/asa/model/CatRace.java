package org.is2.asa.model;


//Enum for Cat razes
public enum CatRace {
    PERSIAN("Persian","resources/images/animals/cats/persian.png"),
    SIAMES ("Siames","resources/images/animals/cats/siames.jpg"),
    SPHYNX ("Sphynx","resources/images/animals/cats/sphynx.jpg"),
    AKITA ("Akita","resources/images/dogs/goldenRetriever1.jpg");



    private String displayName;
    private String imgUrl;

    CatRace(String displayName, String imgUrl){
        this.displayName = displayName;
        this.imgUrl = imgUrl;
    }

    public String DisplayName(){
        return displayName;
    }

    public String getImageLink(){return imgUrl;}
}

