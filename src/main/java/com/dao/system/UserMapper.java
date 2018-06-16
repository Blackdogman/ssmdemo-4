package com.dao.system;

import java.util.List;

import com.model.system.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User getUserByLoginNameAndPassword(User user);

	List<User> listAllUser();
}