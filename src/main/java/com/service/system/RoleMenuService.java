package com.service.system;

import com.model.system.RoleMenu;

import java.util.List;

public interface RoleMenuService {

    List<RoleMenu> listRoleMenuByRoleId(String roleId);

    int changeRoleMenu(String roleId, List<String> menuIdList);
}
