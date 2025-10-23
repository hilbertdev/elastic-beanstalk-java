package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.models.User;

public class UserService {

    private List<User> CurrentUsers = new ArrayList<User>();

    public void addUser(User user) {
        CurrentUsers.add(user);
    }

    public List<User> getAllUsers() {
        return CurrentUsers;
    }

}
