package com.service.system;

import com.model.system.Role;

import java.util.List;

public interface RoleService {
    List<Role> listAllRole();

    int addRole(Role role);

    Role getRoleByRoleId(String roleID);

    int updateRole(Role role);

    int deleteRole(String roleId);
}
