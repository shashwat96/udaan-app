package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user)
    {
        return userRepository.save(user);
    }
    public User getUserByUserId(Long userId)
    {
        return userRepository.findByUserId(userId);
    }
    public boolean checkUserExists(Long userId)
    {
        User user = getUserByUserId(userId);
        if(user != null && user.getUserId() == userId)return true;
        return false;
    }

}
