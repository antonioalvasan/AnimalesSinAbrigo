package org.is2.asa.launcher;

import org.apache.commons.cli.*;
import org.is2.asa.control.LoginController;
import org.is2.asa.dao.UserDao;
import org.is2.asa.model.User;
import org.is2.asa.view.AdopterWindow;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


import org.is2.asa.control.AdopterController;

public class Main {

    //Login messages
    private static final String welcomeMsg = "Welcome!";
    private static final String loginOrRegisterMsg = "Are you a existing user [L], a new refuge [R] or " +
                                                                                    "a new adoptant [A]?";
    private static final String invalidLogin = "Invalid username or password.";
    private static final String invalidRegistration = "That username already exists.";
    private static final String invalidOption = "Invalid option. Please try again.";

    private static UserDao userDao;
    private static LoginController controller;
    private static User loggedUser;
    private static String _inFile = null; //Stores infile address as a string.
    private static Scanner scanner;


    public static void main(String[] args) {
        try{
            scanner = new Scanner(System.in);
            parseArgs(args);
            initUserDatabase();
            identifyUser();
            //User userType = //just to get user type

            AdopterController ctrl = generateControllers();

            System.out.println("Esto es meramente visual");
            for(User user : userDao.getAll()){
                System.out.println(user);
            }

            if(false){refugeWindow();}
            else{adopterWindow(ctrl);}
        }
        catch(Exception e){
            System.err.println("Something went wrong ...");
            System.err.println();
            e.printStackTrace();
        }

    }

    private static AdopterController generateControllers(){
         AdopterController adopterController = new AdopterController(loggedUser);
         return adopterController;
    }

    private static void identifyUser() { //We could use command pattern to control different user commands.
        String answer; //To store user commands from keyboard.
        boolean validOption = false;

        System.out.println(welcomeMsg);
        while(!validOption) {
            System.out.println(loginOrRegisterMsg);
            answer = scanner.nextLine();
            if(answer.equals("L")){
                validOption = login();
                if(!validOption) System.out.println(invalidLogin);
            }
            else if(answer.equals("R")){
                validOption = registerRefuge();
                if(!validOption) System.out.println(invalidRegistration);
            }
            else if(answer.equals("A")){
                validOption = registerAdoptant();
                if(!validOption) System.out.println(invalidRegistration);
            }
            else System.out.println(invalidOption);

        }
    }

    private static boolean login() {
        //User insert his personal data
        String username, password;
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("Login: ");
        password = scanner.nextLine();

        //We check if that user exists and if the password is correct
        boolean found = false;
        int cont = 0;
        User userAux;

        while(!found && cont < userDao.getAll().size()){
            userAux = userDao.get(cont);
            if(userAux.getUsername().equals(username) && userAux.getPassword().equals(password)){
                found = true;
                loggedUser = userAux;
            }
            cont++;
        }
        return found;
    }

    private static boolean registerRefuge(){
        return false;
    }

    private static boolean registerAdoptant(){
        return false;
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
                AdopterWindow w = new AdopterWindow(ctrl);

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
                User usuario = null;
                JFrame frame= new org.is2.asa.view.RefugeeWindow(controller);
                frame.setSize(400,300);
                frame.setVisible(true);

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