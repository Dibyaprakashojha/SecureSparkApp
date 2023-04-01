package com.acxtech.securesparkapp.service;

import com.acxtech.securesparkapp.model.User;
import com.acxtech.securesparkapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findById(username).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
