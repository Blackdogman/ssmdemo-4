package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.UserMapper;
import com.model.system.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserByLoginNameAndPassword(User user) {
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
	public int deleteUserByUserId(String userId) {
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
	
	
	
}
