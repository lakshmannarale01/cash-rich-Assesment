package com.example.cahrich.controller;

import com.example.cahrich.model.User;
import com.example.cahrich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    @Autowired
    private UserService userProfileService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User userProfile) {
        return ResponseEntity.ok(userProfileService.signUp(userProfile));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
        return userProfileService.login(username, password)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateProfile(@RequestBody User userProfile) {
        return ResponseEntity.ok(userProfileService.updateProfile(userProfile));
    }
}
