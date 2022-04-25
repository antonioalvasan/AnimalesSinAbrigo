package org.is2.asa.model;

public class User {

    private Role role;
    private int ID;

    private String username;
    private String password;
    private String name;
    private String province;
    private String address;
    private String tlf;
    private String description;

    public User(Role role, int ID, String username, String password, String name,
                String province, String address, String phone, String desc){
        this.role = role;
        this.ID=ID;
        this.username=username;
        this.password=password;
        this.name = name;
        this.province = province;
        this.address = address;
        this.tlf = phone;
        this.description = desc;
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

    public void setRole(Role role) {
        this.role = role;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return "Username: " + this.username +
                "\nRole: " + this.role +
                "\nCity: " + this.province +
                "\nPhone Number: " + this.tlf;
    }
}
