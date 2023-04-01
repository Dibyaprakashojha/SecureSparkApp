package com.acxtech.securesparkapp.service;

import com.acxtech.securesparkapp.model.UserDetails;
import com.acxtech.securesparkapp.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public void addUser(UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetails getUserDetailById(Long userDetailsId) {
        return userDetailsRepository.findById(userDetailsId).get();
    }

    @Override
    public List<UserDetails> getAllUserDetails() {
        return userDetailsRepository.findAll();
    }
}
