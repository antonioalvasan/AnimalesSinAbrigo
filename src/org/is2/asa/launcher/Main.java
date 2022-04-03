package org.is2.asa.launcher;

import org.apache.commons.cli.*;
import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;

public class Main {

    private static UserDao userDao;

    public static void main(String[] args) {
        userDao = new UserDao();

        for(User user : userDao.getAll()){
            System.out.println(user);
        }
    }

    private static Options buildOptions() {
        Options cmdLineOptions = new Options();

        // help
        cmdLineOptions.addOption(Option.builder("h").longOpt("help").desc("Print this message.").build());

        return cmdLineOptions;
    }

    private static void parseArgs(String[] args) {
        // define the valid command line options
        Options cmdLineOptions = buildOptions();

        // parse the command line as provided in args
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(cmdLineOptions, args);

            //parseModeOption(line);
            // if there are some remaining arguments, then something wrong is
            // provided in the command line!
            //
            String[] remaining = line.getArgs();
            if (remaining.length > 0) {
                String error = "Illegal arguments:";
                for (String o : remaining)
                    error += (" " + o);
                throw new ParseException(error);
            }

        } catch (ParseException e) {
            System.err.println(e.getLocalizedMessage());
            System.exit(1);
        }
    }
}


