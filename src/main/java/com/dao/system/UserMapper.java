package com.dao.system;

import com.model.system.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByLoginNameAndPassword(User user);

    List<User> listAllUser();

    int deleteByPrimaryKeyList(List<String> idList);
}