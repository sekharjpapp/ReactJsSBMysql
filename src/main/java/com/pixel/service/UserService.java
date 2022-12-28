package com.pixel.service;

import com.pixel.exception.UserNotFoundException;
import com.pixel.model.User;
import com.pixel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(int id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id  " + id + "  not in present DB"));
    }
    public List<User> getAllUsersFromDB() {
        return userRepository.findAll();
    }
    public User insertUser(User user) {
        return userRepository.save(user);
    }
}
