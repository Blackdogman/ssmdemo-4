package com.controller.system;

import com.model.system.Role;
import com.model.system.User;
import com.service.system.RoleService;
import com.service.system.UserRoleService;
import com.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/userRoleController")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

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
