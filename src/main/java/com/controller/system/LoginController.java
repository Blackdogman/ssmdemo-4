package com.controller.system;

import com.model.system.User;
import com.service.system.UserService;
import framework.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/loginController")
public class LoginController extends BaseController {

    @RequestMapping("/login.do")
    public String login(User user, HttpSession session, Model model){
        User reUser = userService.getUserByUserNameAndPassword(user);
        if(reUser != null){
            session.setAttribute("loginUser", reUser);
            return "redirect:/view/frame/index.jsp";
        }else {
            model.addAttribute("loginError", "用户名或者密码有误，请检查");
            return "view/frame/login";
        }
    }

}
