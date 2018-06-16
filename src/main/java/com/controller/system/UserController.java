package com.controller.system;

import com.model.system.User;
import com.service.system.UserService;
import framework.utils.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userListUi.do")
    public String userListUi(Model model) {
        List<User> userList = userService.listAllUser();
        model.addAttribute("userList", userList);
        return "view/frame/user/userList";
    }

    @RequestMapping("/addUser.do")
    public String addUser(User user) {
        user.setUserId(PrimaryKeyUtil.getPrimaryKey());
        user.setCreateTime(new Date());
        int flag = userService.addUser(user);
        return "redirect:/userController/userListUi.do";
    }

    @RequestMapping("/deleteUser.do")
    public String deleteUser(String userId) {
        int flag = userService.deleteUser(userId);
        return "redirect:/userController/userListUi.do";
    }

    @RequestMapping("/updateUserUi.do")
    public String updateUserUi(String userId, Model model) {
        User user = userService.getUserByUserId(userId);
        model.addAttribute("user", user);
        return "view/frame/user/userUpdate";
    }

    @RequestMapping("/updateUser.do")
    public String updateUser(User user){
        int flag = userService.updateUser(user);
        return "redirect:/userController/userListUi.do";
    }
}
