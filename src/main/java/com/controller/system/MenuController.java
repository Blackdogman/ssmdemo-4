package com.controller.system;

import com.model.system.Menu;
import com.model.system.Role;
import com.service.system.MenuService;
import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/menuController")
public class MenuController extends BaseController {

    @RequestMapping(value = "menuListUi.do", produces = "application/json;charset=utf-8")
    public String userListUiPage(
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            Model model
    ) {
        PagedResult<Menu> pageResult = menuService.listAllMenuByPage(pageNumber, pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/menupage/menuList";
    }

    @RequestMapping("/addMenuUi.do")
    public String addMenuUi(Model model){
        List<Menu> menuList = menuService.listAllMenu();
        model.addAttribute("menuList", menuList);
        return "view/frame/menupage/menuAdd";
    }

    @RequestMapping("/addMenu.do")
    public String addMenu(Menu menu){
        menu.setMenuId(PrimaryKeyUtil.getPrimaryKey());
        menu.setCreateTime(new Date());
        int flag = menuService.addMenu(menu);
        return "redirect:/menuController/menuListUi.do";
    }

    @RequestMapping("/deleteMenu.do")
    public String deleteMenu(String menuId){
        int flag = menuService.deleteMenu(menuId);
        return "redirect:/menuController/menuListUi.do";
    }

    @RequestMapping("/updateMenuUi.do")
    public String updateMenuUi(String menuId, Model model){
        Menu menu = menuService.getMenuByMenuId(menuId);
        List<Menu> menuList = menuService.listAllMenu();
        model.addAttribute("menuList", menuList);
        model.addAttribute("menu", menu);
        return "view/frame/menupage/menuUpdate";
    }

    @RequestMapping("/updateMenu.do")
    public String updateMenu(Menu menu){
        int flag = menuService.updateMenu(menu);
        return "redirect:/menuController/menuListUi.do";
    }
}
