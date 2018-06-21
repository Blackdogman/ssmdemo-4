package com.dao.system;

import com.model.system.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> listAllMenu();

    List<Menu> getUserMenu(String userId);

    List<Menu> listKidMenuByMenuIdAndUserId(String userId, String menuId);
}