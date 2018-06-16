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
}
