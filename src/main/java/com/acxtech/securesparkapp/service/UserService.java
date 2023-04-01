package com.acxtech.securesparkapp.service;

import com.acxtech.securesparkapp.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
