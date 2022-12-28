package com.pixel.controller;

import com.pixel.exception.UserNotFoundException;
import com.pixel.model.User;
import com.pixel.repository.UserRepository;
import com.pixel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

   @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.getAllUsersFromDB();
    }
    @GetMapping("/user/{id}")
    public User findByUserById(@PathVariable int id) throws UserNotFoundException {
        return userService.getUserById(id);
    }
    @PostMapping("/insert")
    public User addUsers(@RequestBody User user) {
        return userService.insertUser(user);
    }
}
