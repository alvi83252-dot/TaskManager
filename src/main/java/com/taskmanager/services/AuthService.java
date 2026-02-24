package com.taskmanager.services;

import org.springframework.stereotype.Service;

import com.taskmanager.repository.UserRepository;
import com.taskmanager.security.JwtUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.taskmanager.model.User;

@Service
@RequiredArgsConstructor
public class AuthService {
    

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
        .orElseThrow();

        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(username);
        }

        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already taken");
        }
        
        throw new RuntimeException("Invalid credentials");
    }
}
