package com.example.cahrich.service;

import com.example.cahrich.model.User;

import java.util.Optional;


public interface UserService {

    public User signUp(User userProfile);
    public Optional<User> login(String username, String password);
    public User updateProfile(User userProfile);

}

