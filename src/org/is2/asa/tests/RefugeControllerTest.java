package org.is2.asa.tests;

import org.is2.asa.control.RefugeController;
import org.is2.asa.factories.AnimalFactory;
import org.is2.asa.model.DogRace;
import org.is2.asa.model.Role;
import org.is2.asa.model.Dog;
import org.is2.asa.model.User;

import static org.junit.jupiter.api.Assertions.*;

//junit5 implemented tests
class RefugeControllerTest {

    @org.junit.jupiter.api.Test
    void run() {
    }

    @org.junit.jupiter.api.Test
    void changeWindow() {
    }

    @org.junit.jupiter.api.Test
    void changeUserData() {
        User userTest = new User(Role.ADOPTER,10,"Paco", "1234",
                "Paco A de Alfa", "Madrid", "Fernandez de los rios", "623883423", "Buen adoptante");

        User userTest2 = new User(Role.ADOPTER,10,"Paco", "1234",
                "Paco A de Alfa", "Madrid", "Fernandez de los rios", "623883423", "Buen adoptante");

        userTest2.changeUserData("Paco", "1234","Paco A de Alfa", "Madrid", "Fernandez de los rios", "623883423");

        assertEquals(userTest, userTest2);
    }

    @org.junit.jupiter.api.Test
    void getUsername() {
    }

    @org.junit.jupiter.api.Test
    void getPassword() {
    }

    @org.junit.jupiter.api.Test
    void getProvince() {
    }

    @org.junit.jupiter.api.Test
    void getAddress() {
    }

    @org.junit.jupiter.api.Test
    void getTlf() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
    }

    @org.junit.jupiter.api.Test
    void getDescription() {
    }

    @org.junit.jupiter.api.Test
    void createAnimal() {


        Dog Perro = new Dog(1,1, "Toby", 125, 0.5,"Viejo y pequeno", DogRace.BULLDOG,"//",1,"Not Adopted");


    }

    @org.junit.jupiter.api.Test
    void getRefugeAnimals() {
    }

    @org.junit.jupiter.api.Test
    void getRequestedAnimals() {
    }

    @org.junit.jupiter.api.Test
    void testChangeUserData() {
    }
}