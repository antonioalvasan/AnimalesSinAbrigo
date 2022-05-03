package org.is2.asa.dao;

import org.is2.asa.model.Role;
import org.is2.asa.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//DAO design pattern used

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

    //adding a user to users
    @Override
    public void add(User user) {

        if(!existsUser(user)) users.add(user);
        else System.out.println("This username already exists. Please try again.");
    }

    //user update
    @Override
    public void update(User user) {
        //Role and ID can´t be changed
        if(existsUser(user)) {
            users.get(user.getID()).setUsername(user.getUsername());
            users.get(user.getID()).setPassword(user.getPassword());
        }
    }

    //deleting a user from users
    @Override
    public void delete(User user) {
        users.remove(user);
    }

    //loading users from json
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

    //checking if user exists
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

    //creates an instance of a user
    private User createInstance(JSONObject info){
        int ID;
        String username, password, name, province, address, desc, tlf;
        Role role;

        if(info.getString("type").equals("ADOPTER")) role = Role.ADOPTER;
        else role = Role.REFUGE;

        JSONObject data = info.getJSONObject("data");

        ID = data.getInt("ID");
        username = data.getString("username");
        password = data.getString("password");
        name = data.getString("name");
        province = data.getString("province");
        desc = data.getString("description");
        address = data.getString("address");
        tlf = data.getString("tlf");

        return new User(role, ID, username, password, name, province, address, tlf, desc);
    }

    //storing users information into a json
    public String storeAsJSON(){
        JSONObject usersJSON = new JSONObject();
        JSONArray usersJSONArray = new JSONArray();

        for(User u : users){
            usersJSONArray.put(u.toJson());
        }
        usersJSON.put("users", usersJSONArray);

        return usersJSON.toString();
    }

}