package org.is2.asa.launcher;

import org.apache.commons.cli.*;
import org.is2.asa.control.RefugeController;
import org.is2.asa.control.commands.Command;
import org.is2.asa.control.commands.CommandGenerator;
import org.is2.asa.dao.UserDao;
import org.is2.asa.factories.AbstractFactory;
import org.is2.asa.factories.AnimalFactory;
import org.is2.asa.model.Animal;
import org.is2.asa.model.Role;
import org.is2.asa.model.User;
import org.is2.asa.view.AdopterWindow;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


import org.is2.asa.control.AdopterController;
import org.is2.asa.view.RefugeWindow;

public class Main {

    private static String welcomeMsg = "Welcome! Press h to show the help message.";

    private static UserDao userDao;
    private static RefugeController refugeCtrl;
    private static AdopterController adopterCtrl;
    private static User loggedUser;
    private static String _inFile; //Stores infile address as a string.
    private static Scanner scanner;
    private static AbstractFactory<Animal> animalFactory;


    public static void main(String[] args) {
        try{
            animalFactory = new AnimalFactory();
            scanner = new Scanner(System.in);
            parseArgs(args);
            initUserDatabase();

            System.out.println(welcomeMsg);

            do {
                String s = scanner.nextLine();
                String[] input = s.toLowerCase().trim().split(" ");

                Command command = CommandGenerator.parse(input);
                loggedUser = command.execute(userDao, scanner);
            } while(loggedUser == null);

            if(loggedUser.getRole() == Role.REFUGE){
                refugeCtrl = new RefugeController(loggedUser);
                refugeWindow();
            }
            else {
                adopterCtrl = new AdopterController(loggedUser);
                adopterWindow();
            }
        }
        catch(Exception e){
            System.err.println("Something went wrong ...");
            System.err.println();
            e.printStackTrace();
        }
    }

    private static void initUserDatabase() throws FileNotFoundException {
        userDao = new UserDao(); //Initialize the user database.
        InputStream inFile = new FileInputStream(_inFile); //Load input stream.
        userDao.load(inFile);
    }

    private static void adopterWindow(){
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                AdopterWindow w = new AdopterWindow(adopterCtrl);

                w.prepareWindow();
                w.setVisible(true);

                f.setPreferredSize(new Dimension(1300, 600));
                f.add(w);
                f.pack();
                f.setVisible(true);
            }
        }));
    }

    private static void refugeWindow(){
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                RefugeWindow w = new RefugeWindow(refugeCtrl);

                try {
                    w.prepareWindow();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                w.setVisible(true);

                f.setPreferredSize(new Dimension(1300, 600));
                f.add(w);
                f.pack();
                f.setVisible(true);
            }
        }));
    }

    private static Options buildOptions() {
        Options cmdLineOptions = new Options();

        // inFile
        cmdLineOptions.addOption(Option.builder("i").longOpt("input").hasArg().desc("A JSON file " +
                "as database.").build());

        return cmdLineOptions;
    }

    private static void parseArgs(String[] args) {
        // define the valid command line options
        Options cmdLineOptions = buildOptions();

        // parse the command line as provided in args
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(cmdLineOptions, args);

            parseInFileOption(line);

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

    private static void parseInFileOption(CommandLine line) throws ParseException {
        _inFile = line.getOptionValue("i");
        if(_inFile == null) throw new ParseException("An input file is required. This file must be a JSON file.");
    }
}