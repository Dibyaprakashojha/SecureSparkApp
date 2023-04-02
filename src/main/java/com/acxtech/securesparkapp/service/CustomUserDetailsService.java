package com.acxtech.securesparkapp.service;

import com.acxtech.securesparkapp.model.JWTUser;
import com.acxtech.securesparkapp.repository.JWTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private JWTUserRepository jwtUserRepository;

    public void addUser(JWTUser user){
        jwtUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JWTUser user = jwtUserRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid Username");
        }
//        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("USER"));
        return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }
}
