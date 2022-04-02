package org.is2.asa.dao;

import org.is2.asa.model.Role;
import org.is2.asa.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {

    private List<User> users = new ArrayList<>();

    public UserDao() {
        users.add(new User(1, "AntoRecre", "beti", Role.REFUGE));
        users.add(new User(2, "XxenekoretoxX", "ondarroa", Role.ADOPTER));
    }

    @Override
    public User get(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void add(User user) {

        if(!existsUser(user)) users.add(user);
        else System.out.println("This username already exists. Please try again.");
    }

    @Override
    public void update(User user) {
        //Role and ID can´t be changed
        if(existsUser(user)) {
            users.get(user.getID()).setUsername(user.getUsername());
            users.get(user.getID()).setPassword(user.getPassword());
        }
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    //This function searches for a user in the database. Returns false if user doesn't exist, true if it does.
    //This could be done with a try-catch method.
    private boolean existsUser(User user){
        int i = 0;
        boolean exists = false;
        while(!exists && i < users.size()) {
            if (users.get(i).getUsername().equals(user.getUsername())) exists = true;
            else i++;
        }
        return exists;
    }
}