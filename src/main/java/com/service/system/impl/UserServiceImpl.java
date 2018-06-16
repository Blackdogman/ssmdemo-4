package com.service.system.impl;

import com.dao.system.UserMapper;
import com.model.system.User;
import com.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserNameAndPassword(User user) {
        return userMapper.getUserByLoginNameAndPassword(user);
    }
}
