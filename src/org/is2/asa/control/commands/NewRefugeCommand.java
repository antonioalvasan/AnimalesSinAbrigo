package org.is2.asa.control.commands;

import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

import java.util.Scanner;

public class NewRefugeCommand extends Command{
    public NewRefugeCommand(String name, String shortcut) {
        super("RefugeRegister", "r");
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
