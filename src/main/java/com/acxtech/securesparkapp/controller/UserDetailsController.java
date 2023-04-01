package com.acxtech.securesparkapp.controller;

import com.acxtech.securesparkapp.model.User;
import com.acxtech.securesparkapp.model.UserDetails;
import com.acxtech.securesparkapp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userDetails")
@CrossOrigin("*")
public class UserDetailsController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/addUserDetails")
    ResponseEntity<String> addUserDetails(@RequestBody UserDetails userDetails){
        userDetailsService.addUser(userDetails);
        return ResponseEntity.ok("User details Added successfully");
    }

    @GetMapping("/getUserDetail")
    ResponseEntity<UserDetails> getUserDetailsById(@RequestParam Long userId) {
        UserDetails userDetails = userDetailsService.getUserDetailById(userId);
        return ResponseEntity.ok().body(userDetails);
    }

    @GetMapping("/getAllUsers")
    ResponseEntity<List<UserDetails>> getAllUsers() {
        List<UserDetails> userDetailsList = userDetailsService.getAllUserDetails();
        return ResponseEntity.ok().body(userDetailsList);
    }
}
