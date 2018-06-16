package com.service;

import java.util.List;

import com.model.system.User;

public interface UserService {
	User getUserByLoginNameAndPassword(User user);

	List<User> listAllUser();

	int addUser(User user);

	int deleteUserByUserId(String userId);

	User getUserByUserId(String userId);

	int updateUser(User user);
}
