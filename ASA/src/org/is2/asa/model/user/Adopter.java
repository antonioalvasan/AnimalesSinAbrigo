package org.is2.asa.model.user;

public class Adopter extends User {
    private String name;
    private String email;
    private String phone;
    private boolean certificate;


    public Adopter(int ID, String username, String password, Rol rol, String name, String mail, String phone, boolean certificate) {
        super(ID, username, password, Rol.ADOPTER);
        this.name = name;
        this.email = mail;
        this.phone = phone;
        this.certificate = certificate;
    }
}
