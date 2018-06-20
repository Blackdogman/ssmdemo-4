package com.controller.system;

import com.model.system.Role;
import com.model.system.User;
import com.service.system.UserService;
import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {

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

    @RequestMapping("/userRoleSetUi.do")
    public String userRoleSetUi(String userId, Model model){
        User user = userService.getUserByUserId(userId);
        List<Role> roleList = roleService.listAllRole();
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "view/frame/user/userRole";
    }

    @RequestMapping("/updateUserRole.do")
    public String updateUserRole(String userId, String[] roleId){
        List<String> roleIdList = new ArrayList<>(Arrays.asList(roleId));
        System.out.println("userId: " + userId);
        int flag = userRoleService.changeUserRole(userId, roleIdList);
        System.out.println("roleIdList: " + roleIdList);
        return null;
    }
}
