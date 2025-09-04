package com.example.library.service.impl;

import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addNewUser(String name, String password, String email) {
        User user = new User();
        user.setUsername(name);
        user.setPasswordHash(password);
        user.setEmail(email);
        user.setRole(User.Role.Reader);
        user.setStatus(User.Status.active);
        userRepository.save(user);
        return "Saved";
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
