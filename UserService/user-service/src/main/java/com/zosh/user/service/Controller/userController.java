package com.zosh.user.service.Controller;

import com.zosh.user.service.Repository.UserRepository;
import com.zosh.user.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class userController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/API/CreateUser")
    public User createUSER(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("api/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("api/getUserbyID/{UserId}")
    public User getUserByID(@PathVariable long UserId) throws Exception {
        Optional<User> otp = userRepository.findById(UserId);
        if (otp.isPresent()) {
            return otp.get();
        }
        throw new Exception("user not found ");
    }

    @PutMapping("/api/update/{UserId}")
    public User updateUser(@RequestBody User user,
                           @PathVariable Long UserId) throws Exception {
        Optional<User> otp = userRepository.findById(UserId);
        if (otp.isEmpty()) {
            throw new Exception("User not found with given Id");
        }
        User exestingUser = otp.get();
        exestingUser.setFullName(user.getFullName());
        exestingUser.setRole(user.getRole());
        exestingUser.setPhone(user.getPhone());
        return userRepository.save(exestingUser);


    }

    @DeleteMapping("api/deleteUserbyID/{UserId}")
    public String deleteUserByID(@PathVariable long UserId) throws Exception {
        Optional<User> otp = userRepository.findById(UserId);
        if (otp.isEmpty()) {
            throw new Exception("User not found with given Id");
        }
        userRepository.deleteById(UserId);
        return "User deleted";
    }

    @GetMapping("api/users")
    public User getUser() {
        User user = new User();
        user.setEmail("zosh@gmail.com");
        user.setEmail("Ashok verma");
        user.setPhone("+91 9876543210");
        user.setRole("Customer");
        return user;
    }
}
