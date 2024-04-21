package com.JBDL.RestDemoLibrary.service;

import com.JBDL.RestDemoLibrary.domain.User;

import java.util.Map;

public interface UserService {
    public User addUser(User user);
    public User updateUser(String userId, User user);
    public User getUser(String userId);
    public void deleteUser(String userId);
    public Map<String, User> getAllUsers();
}
