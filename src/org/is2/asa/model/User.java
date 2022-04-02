package org.is2.asa.model;

public class User {
    private int ID;
    private String username;
    private String password;
    private Role role;

    public User(int ID, String username, String password, Role role){
        this.ID=ID;
        this.username=username;
        this.password=password;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String toString(){
        return "Username: " + this.username +
                "\nRole: " + this.role;
    }
}
