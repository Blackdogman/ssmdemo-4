package com.service.system.impl;

import com.dao.system.MenuMapper;
import com.model.system.Menu;
import com.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> listAllMenu() {
        return menuMapper.listAllMenu();
    }

    @Override
    public int addMenu(Menu menu) {
        return menuMapper.insertSelective(menu);
    }

    @Override
    public int deleteMenu(String menuId) {
        return menuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public Menu getMenuByMenuId(String menuId) {
        return menuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }
}
