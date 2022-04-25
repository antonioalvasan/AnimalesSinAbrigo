package org.is2.asa.launcher;

import org.apache.commons.cli.*;
import org.is2.asa.control.RefugeController;
import org.is2.asa.control.commands.Command;
import org.is2.asa.control.commands.CommandGenerator;
import org.is2.asa.dao.AnimalDao;
import org.is2.asa.dao.UserDao;
import org.is2.asa.factories.AbstractFactory;
import org.is2.asa.factories.AnimalFactory;
import org.is2.asa.model.Animal;
import org.is2.asa.model.Role;
import org.is2.asa.model.User;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


import org.is2.asa.control.AdopterController;

public class Main {

    //Standard Console Messages
    private static final String welcomeMsg = "Welcome! Press h to show the help message.";

    //Data Access Object (DAO) for animals and users
    private static UserDao userDao;
    private static AnimalDao animalDao;

    //Controllers for windows and usage
    private static RefugeController refugeCtrl;
    private static AdopterController adopterCtrl;

    //Logged User
    private static User loggedUser;

    //JSON input file for animals and users
    private static String _inFileUsers; //Stores infile address as a string.
    private static String _inFileAnimals; //Stores infile address as a string.

    //Scanner
    private static Scanner scanner;


    public static void main(String[] args) {
        try{
            scanner = new Scanner(System.in);
            parseArgs(args);
            initUserDatabase();
            initAnimalsDatabase();

            System.out.println(welcomeMsg);

            do {
                String s = scanner.nextLine();
                String[] input = s.toLowerCase().trim().split(" ");

                Command command = CommandGenerator.parse(input);
                loggedUser = command.execute(userDao, scanner);

            } while(loggedUser == null);

            if(loggedUser.getRole() == Role.REFUGE){
                //refugeCtrl = new RefugeController(loggedUser, );
                refugeWindow();
            }
            else {
                adopterCtrl = new AdopterController(loggedUser, userDao);
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
        InputStream inFile = new FileInputStream(_inFileUsers); //Load input stream.
        userDao.load(inFile);
    }

    private static void initAnimalsDatabase() throws FileNotFoundException {
        animalDao = new AnimalDao(); //Initialize the user database.
        InputStream inFile = new FileInputStream(_inFileAnimals); //Load input stream.
        animalDao.load(inFile);
    }

    private static void adopterWindow(){
        adopterCtrl.run();
    }

    private static void refugeWindow(){
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                String parametro= "Home";
                refugeCtrl.mostrar(parametro);
                refugeCtrl.setPreferredSize(new Dimension(1300, 600));
                refugeCtrl.pack();
                refugeCtrl.setLocationRelativeTo(null);
                refugeCtrl.setVisible(true);
            }
        }));
    }

    private static Options buildOptions() {
        Options cmdLineOptions = new Options();

        // input Users
        cmdLineOptions.addOption(Option.builder("iusers").longOpt("inputUsers").hasArg().desc("A JSON file " +
                "as users' database.").build());

        // input Animals
        cmdLineOptions.addOption(Option.builder("ianimals").longOpt("inputAnimals").hasArg().desc("A JSON file " +
                "as animals' database.").build());

        return cmdLineOptions;
    }

    private static void parseArgs(String[] args) {
        // define the valid command line options
        Options cmdLineOptions = buildOptions();

        // parse the command line as provided in args
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(cmdLineOptions, args);

            parseInUsersOption(line);
            parseInAnimalsOption(line);

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

    private static void parseInUsersOption(CommandLine line) throws ParseException {
        _inFileUsers = line.getOptionValue("iusers");
        if(_inFileUsers == null) throw new ParseException("An input file is required for " +
                "users data. This file must be a JSON file.");
    }

    private static void parseInAnimalsOption(CommandLine line) throws ParseException {
        _inFileAnimals = line.getOptionValue("ianimals");
        if(_inFileAnimals == null) throw new ParseException("An input file is required for" +
                "animals data. This file must be a JSON file.");
    }
}