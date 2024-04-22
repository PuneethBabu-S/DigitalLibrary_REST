package com.JBDL.RestDemoLibrary.service.impl;

import com.JBDL.RestDemoLibrary.domain.User;
import com.JBDL.RestDemoLibrary.repository.UserRepository;
import com.JBDL.RestDemoLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(Integer userId, User user) {
        Optional<User> originalUser = userRepository.findById(userId);
        if (originalUser.isPresent()) {
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
