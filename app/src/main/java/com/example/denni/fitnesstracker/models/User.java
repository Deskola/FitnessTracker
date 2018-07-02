package com.example.denni.fitnesstracker.models;

public class User {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String username;
    private String password;

    public User(String name, String email, String gender, String username, String password) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    public User(int id, String name, String email, String gender, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }



    public User(int id, String name, String email, String gender, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
