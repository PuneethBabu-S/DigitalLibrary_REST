package com.JBDL.RestDemoLibrary.service;

import com.JBDL.RestDemoLibrary.domain.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public Boolean updateUser(Integer userId, User user);
    public User getUser(Integer userId);
    public void deleteUser(Integer userId);
    public List<User> getAllUsers();
}
