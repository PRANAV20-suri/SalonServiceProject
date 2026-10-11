package com.zosh.user.service.Service;

import com.zosh.user.service.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long userId);

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);

    User getSampleUser();
}
