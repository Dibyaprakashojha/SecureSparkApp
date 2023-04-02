package com.acxtech.securesparkapp.controller;

import com.acxtech.securesparkapp.model.JWTUser;
import com.acxtech.securesparkapp.model.JwtResponse;
import com.acxtech.securesparkapp.service.CustomUserDetailsService;
import com.acxtech.securesparkapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class JWTUserController {

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/users/token")
    ResponseEntity<?> generateToken(@RequestBody JWTUser user) throws Exception {
        try{
            this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Username not found");
        }catch (BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad credentials");
        }
        UserDetails userDetails = this.userService.loadUserByUsername(user.getUsername());
        String token = this.jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/users/addUser")
    ResponseEntity<String> addUser(@RequestBody JWTUser user){
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        String fullName = user.getFullName();
        JWTUser jwtUser = new JWTUser(username,fullName,password);
        userService.addUser(jwtUser);
        return ResponseEntity.ok("User added successfully");
    }
}
