package org.is2.asa.model.user;

import org.is2.asa.model.animal.Animal;

import java.util.ArrayList;

/**
 *
 */
public class Refuge extends User {
    private String name;
    private String email;
    private String phone;
    private int maxCapacity;
    private String location;
    private ArrayList<Animal> animalList;

    public Refuge(int ID, String username, String password, Rol rol, String name, String email, String phone, int maxCapacity, String location, ArrayList<Animal> animalList) {
        super(ID, username, password, Rol.REFUGE);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.maxCapacity = maxCapacity;
        this.location = location;
        this.animalList = animalList;
    }
}
