package org.is2.asa.model.user;

import org.is2.asa.model.user.Rol;

public abstract class User {
    private int ID;
    private String username;
    private String password;
    private Rol rol;

    public User(int ID, String username, String password, Rol rol){
        this.ID=ID;
        this.username=username;
        this.password=password;
        this.rol=rol;
    }

}
