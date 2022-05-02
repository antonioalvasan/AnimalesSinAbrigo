package org.is2.asa.control.commands;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.Role;
import org.is2.asa.model.User;

import java.util.Scanner;

public class NewAdopterCommand extends Command{

    protected final static String name = "AdopterRegister";
    protected final static String shortcut = "a";

    public NewAdopterCommand() {
        super(name, shortcut);
    }

    @Override
    public User execute(UserDao userDao, Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm password: ");
        String passwordConf = scanner.nextLine();

        while(!password.equals(passwordConf)){
            System.out.print("Passwords don't match. Please try again: ");
            passwordConf = scanner.nextLine();
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Province: ");
        String province = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone Number: ");
        String tlf = scanner.nextLine();
        System.out.print("Description (optional): ");
        String desc = scanner.nextLine();

        User loggedUser = new User(Role.ADOPTER, username, password, name, province,
                address, tlf, desc);
        userDao.add(loggedUser);

        return loggedUser;
    }

    @Override
    public Command parse(String[] input) {
        if(input[0].equalsIgnoreCase("adopter") || input[0].equalsIgnoreCase("a"))
            input[0] = shortcut;
        return parseNoParamsCommand(input);
    }
}
