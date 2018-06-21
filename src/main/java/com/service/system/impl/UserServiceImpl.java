package com.service.system.impl;

import com.dao.system.UserMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.User;
import com.service.system.UserService;
import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserNameAndPassword(User user) {
        return userMapper.getUserByLoginNameAndPassword(user);
    }

    @Override
    public List<User> listAllUser() {
        return userMapper.listAllUser();
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int deleteUser(String userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User getUserByUserId(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public PagedResult<User> listAllByPage(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<User> userList = userMapper.listAllUser();
        return PageBeanUtil.toPagedResult(userList);
    }
}
