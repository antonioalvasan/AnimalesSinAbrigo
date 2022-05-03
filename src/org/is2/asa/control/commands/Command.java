package org.is2.asa.control.commands;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

import java.util.Scanner;

//Command design pattern is used
public abstract class Command {

    protected final String name;
    protected final String shortcut;

    protected static final String incorrectNumberOfArgsMsg = "Incorrect number of arguments";
    protected static final String incorrectArgsMsg = "Incorrect arguments format";

    //Command constructor
    public Command(String name,  String shortcut){
        this.name = name;
        this.shortcut = shortcut;
    }

    public abstract User execute(UserDao userDao, Scanner scanner);

    public abstract Command parse(String[] input);

    protected boolean matchCommandName(String name) {
        return this.shortcut.equalsIgnoreCase(name) ||
                this.name.equalsIgnoreCase(name);
    }

    protected Command parseNoParamsCommand(String[] words){
        if (matchCommandName(words[0])) {
            if (words.length != 1)
                ;
            else return this;
        }

        return null;
    }


}