package org.is2.asa.control.commands;

public class CommandGenerator {
    private static Command[] availableCommands = {

    };

    public static Command parse(String[] parameters) {
        Command com = null;
        for(Command c : availableCommands) {
            com = c.parse(parameters);
            if(com != null)
                return com;
        }
        return null;
    }
}
