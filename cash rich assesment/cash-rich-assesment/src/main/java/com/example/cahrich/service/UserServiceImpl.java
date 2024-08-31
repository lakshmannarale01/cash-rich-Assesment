package com.example.cahrich.service;
import com.example.cahrich.model.User;
import com.example.cahrich.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;



@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userProfileRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User signUp(User userProfile) {
        userProfile.setPassword(passwordEncoder.encode(userProfile.getPassword()));
        return userProfileRepository.save(userProfile);
    }

    public Optional<User> login(String username, String password) {
        Optional<User> userProfile = userProfileRepository.findByUsername(username);
        if (userProfile.isPresent() && passwordEncoder.matches(password, userProfile.get().getPassword())) {
            return userProfile;
        }
        return Optional.empty();
    }

    public User updateProfile(User userProfile) {
        return userProfileRepository.save(userProfile);
    }
}
