package com.JBDL.RestDemoLibrary.service.impl;

import com.JBDL.RestDemoLibrary.domain.User;
import com.JBDL.RestDemoLibrary.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    Map<String, User> users = new HashMap<>();
    int uid = 1;

    @Override
    public User addUser(User user) {
        user.setUserId(String.valueOf(uid++));
        users.put(user.getUserId(), user);
        return user;
    }

    @Override
    public User updateUser(String userId, User user) {
        users.computeIfPresent(userId, (k, v) -> {v.setUserId(userId); return v;});
        return user;
    }

    @Override
    public User getUser(String userId) {
        return users.getOrDefault(userId, null);
    }

    @Override
    public void deleteUser(String userId) {
        users.remove(userId);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return users;
    }
}
