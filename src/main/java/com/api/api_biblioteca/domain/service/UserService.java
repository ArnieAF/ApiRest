package com.api.api_biblioteca.domain.service;

import com.api.api_biblioteca.domain.User;
import com.api.api_biblioteca.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findByNameContaining(String name) {
        return userRepository.findByNameContaining(name);
    }

    public Optional<User> findById(int userId) {
        return userRepository.findById(userId);
    }

    public List<User> findByRegistrationDateBetween(LocalDateTime start, LocalDateTime end) {
        return userRepository.findByRegistrationDateBetween(start, end);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public long countByRegistrationDateBetween(LocalDateTime start, LocalDateTime end) {
        return userRepository.countByRegistrationDateBetween(start, end);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean delete(int userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
