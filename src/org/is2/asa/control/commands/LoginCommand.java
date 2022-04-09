package org.is2.asa.control.commands;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

import java.util.Scanner;

public class LoginCommand extends Command {
    public LoginCommand(String name, String shortcut) {
        super("login", "l");
    }

    @Override
    public User execute(UserDao userDao, Scanner scanner) {
        return null;
    }

    @Override
    public Command parse(String[] input) {
        if(input[0].equalsIgnoreCase("login") || input[0].equalsIgnoreCase("l"))
            input[0] = shortcut;
        return parseNoParamsCommand(input);
    }
}
