package org.is2.asa.control.commands;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

import java.util.Scanner;

//Command design pattern is used
public class LoginCommand extends Command {

    protected final static String name = "login";
    protected final static String shortcut = "l";

    private static final String invalidLoginMsg = "Invalid username or password.";

    public LoginCommand() {
        super(name, shortcut);
    }

    @Override
    public User execute(UserDao userDao, Scanner scanner) {

        //User insert his personal data
        String username, password;
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("Login: ");
        password = scanner.nextLine();

        //We check if that user exists and if the password is correct
        User userAux;

        for(int i = 0; i< userDao.getAll().size(); i++){
            userAux = userDao.get(i);
            if(userAux.getUsername().equals(username) && userAux.getPassword().equals(password)) return userAux;
        }

        System.out.println(invalidLoginMsg);
        return null;
    }

    @Override
    public Command parse(String[] input) {
        if(input[0].equalsIgnoreCase("login") || input[0].equalsIgnoreCase("l"))
            input[0] = shortcut;
        return parseNoParamsCommand(input);
    }
}