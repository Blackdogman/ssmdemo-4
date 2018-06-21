package com.service.system;

import com.model.system.Menu;
import framework.utils.pageUtil.PagedResult;

import java.util.List;

public interface MenuService {
    List<Menu> listAllMenu();

    int addMenu(Menu menu);

    int deleteMenu(String menuId);

    Menu getMenuByMenuId(String menuId);

    int updateMenu(Menu menu);

    PagedResult<Menu> listAllMenuByPage(Integer pageNumber, Integer pageSize);

    List<Menu> getUserMenu(String userId);

    List<Menu> listKidMenuByMenuIdAndUserId(String userId, String menuId);
}
