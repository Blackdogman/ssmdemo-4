package com.service.system;

import com.model.system.UserRole;

import java.util.List;

public interface UserRoleService {
    int changeUserRole(String userId, List<String> roleIdList);

    List<UserRole> listUserRoleByUserId(String userId);
}
