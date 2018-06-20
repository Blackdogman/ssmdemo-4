package com.service.system.impl;

import com.dao.system.RoleMenuMapper;
import com.model.system.RoleMenu;
import com.model.system.UserRole;
import com.service.system.RoleMenuService;
import framework.utils.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<RoleMenu> listRoleMenuByRoleId(String roleId) {
        return roleMenuMapper.selectByRoleId(roleId);
    }

    @Override
    public int changeRoleMenu(String roleId, List<String> menuIdList) {
        int flag = roleMenuMapper.deleteByRoleId(roleId);
        int flag2 = -1;
        List<RoleMenu> roleMenuList = new ArrayList<>();
        for (String menuId : menuIdList) {
            roleMenuList.add(new RoleMenu(PrimaryKeyUtil.getPrimaryKey(),roleId,menuId));
        }
        for (RoleMenu item : roleMenuList) {
            flag2 = roleMenuMapper.insertSelective(item);
        }
        return flag2;
    }
}
