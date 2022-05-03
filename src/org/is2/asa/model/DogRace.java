package org.is2.asa.model;

//Enum for Dog razes
public enum DogRace {
    GOLDEN_RETRIEVER ("Golden Retriever","resources/images/animals/dogs/goldenretriever.jpg"),
    BORDER_COLLIE ("Border Collie", "resources/images/animals/dogs/bordercollie.jpg"),
    ALASKAN_MALAMUTE ("Alaskan Malamute", "resources/images/animals/dogs/alaskanmalamut.jpg"),
    BULLDOG ("Perro toro", "resources/images/animals/dogs/bulldog.jpg"),
    AKITA ("Akita", "resources/images/animals/dogs/akita.jpg"),
    BULLTERRIER ("Bull Terrier", "resources/images/animals/dogs/bullterrier.jpg"),
    LABRADOR ("Labrador", "resources/images/animals/dogs/labrador.jpg");


    private String displayName;
    private String imgUrl;

    DogRace(String displayName, String imgUrl){
        this.displayName = displayName;
        this.imgUrl= imgUrl;
    }

    public String DisplayName(){
        return displayName;
    }

    public String getImageLink(){return imgUrl;}
}
