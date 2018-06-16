package com.service.system.impl;

import com.dao.system.RoleMapper;
import com.model.system.Role;
import com.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> listAllRole() {
        return roleMapper.listAllRole();
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public Role getRoleByRoleId(String roleID) {
        return roleMapper.selectByPrimaryKey(roleID);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int deleteRole(String roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }
}
