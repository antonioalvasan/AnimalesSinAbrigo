package org.is2.asa.control.commands;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

import java.util.Scanner;

public class ExitCommand extends Command{

    protected final static String name = "help";
    protected final static String shortcut = "h";

    public ExitCommand(String name, String shortcut) {
        super(name, shortcut);
    }

    @Override
    public User execute(UserDao userDao, Scanner scanner) {
        System.exit(0);
        return null;
    }

    @Override
    public Command parse(String[] input) {
        if(input[0].equalsIgnoreCase("exit") || input[0].equalsIgnoreCase("e"))
            input[0] = shortcut;
        return parseNoParamsCommand(input);
    }
}
