package org.is2.asa.control.commands;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.Role;
import org.is2.asa.model.User;

import java.util.Scanner;

public class NewRefugeCommand extends Command{

    protected final static String name = "RefugeRegister";
    protected final static String shortcut = "r";

    public NewRefugeCommand() {
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

        User loggedUser = new User(userDao.getAll().size()+1, username, password, Role.REFUGE);
        userDao.add(loggedUser);

        return loggedUser;
    }

    @Override
    public Command parse(String[] input) {
        if(input[0].equalsIgnoreCase("refuge") || input[0].equalsIgnoreCase("r"))
            input[0] = shortcut;
        return parseNoParamsCommand(input);
    }
}
