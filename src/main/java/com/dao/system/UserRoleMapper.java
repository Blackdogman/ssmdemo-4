package com.dao.system;

import com.model.system.UserRole;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(String userRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<UserRole> selectByUserId(String userId);

    int deleteByUserId(String userId);
}