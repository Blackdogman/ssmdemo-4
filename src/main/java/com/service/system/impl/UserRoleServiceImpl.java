package com.service.system.impl;

import com.dao.system.UserRoleMapper;
import com.model.system.UserRole;
import com.service.system.UserRoleService;
import framework.utils.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int changeUserRole(String userId, List<String> roleIdList) {
        int flag = userRoleMapper.deleteByUserId(userId);
        int flag2 = -1;
        List<UserRole> userRoleList = new ArrayList<>();
        for (String roleId : roleIdList) {
            userRoleList.add(new UserRole(PrimaryKeyUtil.getPrimaryKey(), userId, roleId));
        }
        for (UserRole item : userRoleList) {
            flag2 = userRoleMapper.insertSelective(item);
        }
        return flag2;
    }

    @Override
    public List<UserRole> listUserRoleByUserId(String userId) {
        return userRoleMapper.selectByUserId(userId);
    }
}
