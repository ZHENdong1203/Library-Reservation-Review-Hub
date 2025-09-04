package com.example.library.controller;

import com.example.library.model.User;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/add")
    public String addNewUser(@RequestParam String name,
                             @RequestParam String password,
                             @RequestParam String email) {
        return userService.addNewUser(name, password, email);
    }

    @GetMapping(path="/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
