package com.example.library.service;

import com.example.library.model.User;

public interface UserService {
    String addNewUser(String name, String password, String email);

    Iterable<User> getAllUsers();
}
