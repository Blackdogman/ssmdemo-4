package com.service.system;

import com.model.system.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> listAllMenu();

    int addMenu(Menu menu);

    int deleteMenu(String menuId);

    Menu getMenuByMenuId(String menuId);

    int updateMenu(Menu menu);
}
