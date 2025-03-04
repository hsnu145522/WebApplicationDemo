package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<Users> findById(Long id) {
        return Optional.ofNullable(userRepository.findAll().stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null));
    }

    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    public void addUser(Users user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, Users user) {
        Optional<Users> existUser = userRepository.findById(id);
        if (existUser.isPresent()) {
            user.setId(id);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User id not found");
        }
    }

    public void deleteUser(Long id) {
        Optional<Users> existUser = userRepository.findById(id);
        if (existUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User id not found");
        }
    }

}
