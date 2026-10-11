package com.zosh.user.service.Service;


import com.zosh.user.service.Exception.UserNotException;
import com.zosh.user.service.Repository.UserRepository;
import com.zosh.user.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        try {
            return userRepository.findById(userId).orElseThrow(() -> new UserNotException("User not found with ID: " + userId));
        } catch (UserNotException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User updateUser(Long userId, User user) {
        User existingUser = getUserById(userId);

        existingUser.setFullName(user.getFullName());
        existingUser.setRole(user.getRole());
        existingUser.setPhone(user.getPhone());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = getUserById(userId);
        userRepository.delete(existingUser);
    }

    @Override
    public User getSampleUser() {
        User user = new User();
        user.setFullName("Ashok Verma");
        user.setEmail("zosh@gmail.com");
        user.setPhone("+91 9876543210");
        user.setRole("Customer");

        return user;
    }
}