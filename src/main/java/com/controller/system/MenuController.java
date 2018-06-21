package com.controller.system;

import com.model.system.Menu;
import com.model.system.Role;
import com.model.system.User;
import com.service.system.MenuService;
import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    public String addMenuUi(Model model) {
        List<Menu> menuList = menuService.listAllMenu();
        model.addAttribute("menuList", menuList);
        return "view/frame/menupage/menuAdd";
    }

    @RequestMapping("/addMenu.do")
    public String addMenu(Menu menu) {
        menu.setMenuId(PrimaryKeyUtil.getPrimaryKey());
        menu.setCreateTime(new Date());
        int flag = menuService.addMenu(menu);
        return "redirect:/menuController/menuListUi.do";
    }

    @RequestMapping("/deleteMenu.do")
    public String deleteMenu(String menuId) {
        int flag = menuService.deleteMenu(menuId);
        return "redirect:/menuController/menuListUi.do";
    }

    @RequestMapping("/updateMenuUi.do")
    public String updateMenuUi(String menuId, Model model) {
        Menu menu = menuService.getMenuByMenuId(menuId);
        List<Menu> menuList = menuService.listAllMenu();
        model.addAttribute("menuList", menuList);
        model.addAttribute("menu", menu);
        return "view/frame/menupage/menuUpdate";
    }

    @RequestMapping("/updateMenu.do")
    public String updateMenu(Menu menu) {
        int flag = menuService.updateMenu(menu);
        return "redirect:/menuController/menuListUi.do";
    }

    @RequestMapping("/getKidMenuList.do")
    public void getKidMenuList(HttpServletResponse resp, HttpServletRequest request, HttpSession session, String menuId) {
        try {
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
            resp.setContentType("text/html; charset=utf-8;");
            String userId = ((User) session.getAttribute("loginUser")).getUserId();
            List<Menu> menuList = menuService.listKidMenuByMenuIdAndUserId(userId, menuId);
            StringBuilder sb = new StringBuilder();
            for (Menu menu : menuList) {
                sb.append("<li>");
                sb.append("<a href=\""+ basePath + menu.getAnthortyUrl() + "\" target=\"right\">");
                sb.append("<span class=\"icon-caret-right\"></span>" + menu.getAnthortyName() + "");
                sb.append("</a>");
                sb.append("</li>");
            }
            resp.getWriter().print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
