package org.is2.asa.view.adopter;

public enum AdopterWindowCodes {
    ADOPTERHOMEWINDOW ("AHW"),
    ADOPTERUSERINFOWINDOW("AUIW"),
    ADOPTERUSERINFOWINDOW2("AUIW2"),
    REFUGECONTACTWINDOW("RCW"),
    SECONDARYADOPTIONWINDOW1("SAW1"),
    SECONDARYADOPTIONWINDOW2("SAW2");

    private final String windowCode;

    AdopterWindowCodes(String displayName){
        this.windowCode = displayName;
    }

    public String getWindowCode(){
        return windowCode;
    }
}
