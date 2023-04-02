package com.acxtech.securesparkapp.controller;

import com.acxtech.securesparkapp.model.UserDetails;
import com.acxtech.securesparkapp.service.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/userDetails/addUserDetails")
    ResponseEntity<String> addUserDetails(@RequestBody UserDetails userDetails){
        System.out.println("Inside details");
        UserDetails details = new UserDetails();
        details.setAddress(userDetails.getAddress());
        details.setFullName(userDetails.getFullName());
        details.setHobbies(userDetails.getHobbies());
        details.setSkills(userDetails.getSkills());
        details.setMobileNumber(userDetails.getMobileNumber());
        details.setFileId(userDetails.getFileId());
        userDetailsService.addUser(details);
        return ResponseEntity.ok("User details Added successfully");
    }

    @GetMapping("/userDetails/getUserDetail")
    ResponseEntity<UserDetails> getUserDetailsById(@RequestParam Long userId) {
        UserDetails userDetails = userDetailsService.getUserDetailById(userId);
        return ResponseEntity.ok().body(userDetails);
    }

    @GetMapping("/userDetails/getAllUsers")
    ResponseEntity<List<UserDetails>> getAllUsers() {
        List<UserDetails> userDetailsList = userDetailsService.getAllUserDetails();
        return ResponseEntity.ok().body(userDetailsList);
    }
}
