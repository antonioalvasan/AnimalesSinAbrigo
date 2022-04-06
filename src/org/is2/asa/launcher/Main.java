package org.is2.asa.launcher;

import org.apache.commons.cli.*;
import org.is2.asa.control.Controller;
import org.is2.asa.dao.UserDao;
import org.is2.asa.model.Role;
import org.is2.asa.model.User;
import org.is2.asa.view.AdopterWindow;
import org.is2.asa.view.LoginWindow;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {

    private static UserDao userDao;
    private static Controller controller;
    private static String _inFile = null; //Stores infile address as a string.

    public static void main(String[] args) {
        try{
            parseArgs(args);
            initUserDatabase();

            //User userType = //just to get user type

            for(User user : userDao.getAll()){
                System.out.println(user);
            }

            /*if(loginWindow().getRole().equals(Role.REFUGE)){ //login window obtains user role
                refugeWindow();
            }
            else{
                adopterWindow();
            }*/
            loginWindow();
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

    private static void loginWindow(){
        //User exampleUser = new User();
        //exampleUser.setRole(Role.ADOPTER);
        //return exampleUser;

        SwingUtilities.invokeLater((new Runnable(){
            @Override
            public void run(){
                JFrame f = new JFrame();
                LoginWindow l = new LoginWindow();

                l.prepareWindow();
                l.setVisible(true);

                f.setPreferredSize(new Dimension(1300, 600));
                f.add(l);
                f.pack();
                f.setVisible(true);
            }
        }));
    }

    private static void adopterWindow(){
        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                AdopterWindow w = new AdopterWindow();

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

    private static void userWindow(){

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