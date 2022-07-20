package com.simpleProject.tasksList.service.impl;

import com.simpleProject.tasksList.dto.UserDto;
import com.simpleProject.tasksList.model.User;
import com.simpleProject.tasksList.repository.UserRepository;
import com.simpleProject.tasksList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }
}
