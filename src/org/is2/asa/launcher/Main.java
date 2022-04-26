package org.is2.asa.launcher;

import org.apache.commons.cli.*;
import org.is2.asa.control.AnimalListController;
import org.is2.asa.control.RefugeController;
import org.is2.asa.control.commands.Command;
import org.is2.asa.control.commands.CommandGenerator;
import org.is2.asa.dao.AnimalDao;
import org.is2.asa.dao.UserDao;
import org.is2.asa.model.Role;
import org.is2.asa.model.User;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


import org.is2.asa.control.AdopterController;
import org.is2.asa.view.viewFactories.BuilderBasedWindowFactory;

public class Main {

    //Standard Console Messages
    private static final String welcomeMsg = "Welcome! Press h to show the help message.";

    //Data Access Object (DAO) for animals and users
    private static UserDao userDao;
    private static AnimalDao animalDao;

    //Controllers for windows and usage
    private static RefugeController refugeCtrl;
    private static AdopterController adopterCtrl;
    private static AnimalListController animalListController;

    //Logged User
    private static User loggedUser;

    //JSON input file for animals and users
    private static String _usersFile; //Stores infile address as a string.
    private static String _animalsFile; //Stores infile address as a string.

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
                refugeCtrl = new RefugeController(loggedUser, userDao, animalDao, _usersFile, _animalsFile);
                refugeWindow();
            }
            else {
                adopterCtrl = new AdopterController(loggedUser, userDao, animalDao, _usersFile, _animalsFile,
                        animalListController);
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
        InputStream inFile = new FileInputStream(_usersFile); //Load input stream.
        userDao.load(inFile);
    }

    private static void initAnimalsDatabase() throws FileNotFoundException {
        animalDao = new AnimalDao(); //Initialize the user database.
        InputStream inFile = new FileInputStream(_animalsFile); //Load input stream.
        animalDao.load(inFile);
    }

    private static void adopterWindow(){
        adopterCtrl.run();
    }

    private static void refugeWindow(){ refugeCtrl.run(); }

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
        _usersFile = line.getOptionValue("iusers");
        if(_usersFile == null) throw new ParseException("An input file is required for " +
                "users data. This file must be a JSON file.");
    }

    private static void parseInAnimalsOption(CommandLine line) throws ParseException {
        _animalsFile = line.getOptionValue("ianimals");
        if(_animalsFile == null) throw new ParseException("An input file is required for" +
                "animals data. This file must be a JSON file.");
    }
}