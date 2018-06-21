package com.controller.system;

import com.model.system.Menu;
import com.model.system.User;
import com.service.system.UserService;
import framework.controller.BaseController;
import framework.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/loginController")
public class LoginController extends BaseController {

    @RequestMapping("/login.do")
    public String login(User user, HttpSession session, Model model){
        User reUser = userService.getUserByUserNameAndPassword(user);
        if(reUser != null){
            session.setAttribute("loginUser", reUser);
            List<Menu> menuList = menuService.getUserMenu(reUser.getUserId());
            model.addAttribute("menuList", menuList);
            return "view/frame/index";
        }else {
            model.addAttribute("loginError", "用户名或者密码有误，请检查");
            return "view/frame/login";
        }
    }
}

class MenuListModel{
    private Menu menu;
    private List<Menu> menuList;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "MenuListModel{" +
                "menu=" + menu +
                ", menuList=" + menuList +
                '}';
    }
}
