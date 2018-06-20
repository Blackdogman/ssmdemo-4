package com.service.system;

import java.util.List;

public interface UserRoleService {
    int changeUserRole(String userId, List<String> roleIdList);
}
