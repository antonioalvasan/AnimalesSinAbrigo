package org.is2.asa.control.commands;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

import java.util.Scanner;

public class NewAdopterCommand extends Command{
    public NewAdopterCommand(String name, String shortcut) {
        super("AdopterRegister", "a");
    }

    @Override
    public User execute(UserDao userDao, Scanner scanner) {
        return null;
    }

    @Override
    public Command parse(String[] commandWords) {
        return null;
    }
}
