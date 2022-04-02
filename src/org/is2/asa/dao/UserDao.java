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
        users.add(user);
    }

    @Override
    public void update(User user) {
        users.get(user.getID()).setUsername(user.getUsername());
        users.get(user.getID()).setPassword(user.getPassword());
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}