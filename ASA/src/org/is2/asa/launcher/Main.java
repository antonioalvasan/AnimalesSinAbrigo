package org.is2.asa.launcher;

import org.is2.asa.model.user.Rol;

public class Main {
    private Rol actualRol;

    public static void main(String[] args) {
        try {
            init();
            start(args);
        } catch (Exception e) {
            System.err.println("Something went wrong ...");
            System.err.println();
            e.printStackTrace();
        }
    }

    private static void init(){


    }

    private static void start(){

    }

    private static void startRefugeMode(){

    }

    private static void startAdopterMode(){

    }

}
