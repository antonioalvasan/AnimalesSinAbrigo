package org.is2.asa.dao;

import org.is2.asa.model.Role;
import org.is2.asa.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {

    private List<User> users = new ArrayList<>();

    public UserDao() {

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

    @Override
    public void load(InputStream in) {
        JSONObject jsonInput = new JSONObject(new JSONTokener(in));
        JSONArray userArray = jsonInput.getJSONArray("users");

        User userAux;
        for(int i = 0; i<userArray.length(); i++){
            userAux = createInstance(userArray.getJSONObject(i)); //CreateInstance may be on a factory
            users.add(userAux);
        }
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

    private User createInstance(JSONObject info){
        int ID;
        String username, password;
        Role role;

        if(info.getString("type").equals("ADOPTER")) role = Role.ADOPTER;
        else role = Role.REFUGE;

        JSONObject data = info.getJSONObject("data");
        username = data.getString("username");
        password = data.getString("password");
        ID = data.getInt("ID");

        return new User(ID, username, password, role);
    }
}