package org.is2.asa.control.commands;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

import java.util.Scanner;

//Command design pattern is used
public class HelpCommand extends Command{

    protected final static String name = "help";
    protected final static String shortcut = "h";

    private static final String helpMsg = String.format("Available commands%n" +
            "[l]ogin: log in already existing account%n" +
            "[a]dopter: register a new adopter%n" +
            "[r]efuge: register a new refuge%n" +
            "[h]elp: show this help message%n" +
            "[e]xit: exit%n"
    );

    public HelpCommand() {
        super(name, shortcut);
    }

    @Override
    public User execute(UserDao userDao, Scanner scanner) {
        System.out.println(helpMsg);
        return null;
    }

    @Override
    public Command parse(String[] input) {
        if(input[0].equalsIgnoreCase("help") || input[0].equalsIgnoreCase("h"))
            input[0] = shortcut;
        return parseNoParamsCommand(input);
    }
}
