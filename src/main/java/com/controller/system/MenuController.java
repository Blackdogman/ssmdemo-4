package com.controller.system;

import com.model.system.Menu;
import com.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menuController")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/menuListUi.do")
    public String menuListUi(Model model){
        List<Menu> menuList = menuService.listAllMenu();
        model.addAttribute("menuList", menuList);
        return "/view/frame/menu/menuList";
    }
}
