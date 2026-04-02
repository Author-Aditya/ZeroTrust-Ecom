package com.dailymart.store.serviceImpl;

import com.dailymart.store.dtos.AuthRequest;
import com.dailymart.store.dtos.AuthResponse;
import com.dailymart.store.entity.User;
import com.dailymart.store.repository.UserRepository;
import com.dailymart.store.util.AppConstants;
import com.dailymart.store.util.DateUtil;
import com.dailymart.store.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public AuthResponse register(AuthRequest request) {

        // Check if email already exists
        userRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            throw new RuntimeException("Email already registered");
        });

        // Create new user
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);
        user.setFailedLoginAttempts(0);
        user.setAccountLockedUntil(null);

        userRepository.save(user);

        // Generate JWT token
        String token = JwtUtil.generateToken(user.getEmail());

        return new AuthResponse("User registered successfully", token);
    }

    @Transactional
    public AuthResponse login(AuthRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 1. Check if account is active
        if (!user.isActive()) {
            throw new RuntimeException("Account is deactivated");
        }

        // 2. Check if account is locked
        if (user.getAccountLockedUntil() != null &&
                user.getAccountLockedUntil().isAfter(LocalDateTime.now())) {
            throw new RuntimeException("Account is locked. Try again later");
        }

        // 3. Validate password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            int attempts = user.getFailedLoginAttempts() + 1;
            user.setFailedLoginAttempts(attempts);

            // Lock account if max attempts reached
            if (attempts >= AppConstants.MAX_LOGIN_ATTEMPTS) {
                user.setAccountLockedUntil(
                        DateUtil.plusMinutes(AppConstants.LOCK_TIME_MINUTES)
                );
            }

            userRepository.save(user);

            throw new RuntimeException("Invalid credentials");
        }

        // 4. Reset attempts on successful login
        user.setFailedLoginAttempts(0);
        user.setAccountLockedUntil(null);

        userRepository.save(user);

        // 5. Generate JWT token
        String token = JwtUtil.generateToken(user.getEmail());

        return new AuthResponse("Login successful", token);
    }
}