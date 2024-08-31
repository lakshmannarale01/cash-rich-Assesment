package com.example.cahrich.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.cahrich.model.User;
import com.example.cahrich.repository.UserRepository;
import com.example.cahrich.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserProfileServiceTest {
    @Mock
    private UserRepository userProfileRepository;

    @InjectMocks
    private UserService userProfileService;

    @Test
    public void testSignUp() {
        User userProfile = new User();
        userProfile.setUsername("testuser");
        userProfile.setPassword("Test@1234");

        when(userProfileRepository.save(any(User.class))).thenReturn(userProfile);

        User result = userProfileService.signUp(userProfile);
        assertEquals("testuser", result.getUsername());
    }
}
