package com.acxtech.securesparkapp.service;

import com.acxtech.securesparkapp.model.UserDetails;

import java.util.List;

public interface UserDetailsService {
    void addUser(UserDetails userDetails);
    UserDetails getUserDetailById(Long userDetailsId);
    List<UserDetails> getAllUserDetails();
}
