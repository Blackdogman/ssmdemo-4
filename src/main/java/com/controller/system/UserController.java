package com.controller.system;

import com.model.system.Role;
import com.model.system.User;
import com.model.system.UserRole;
import framework.controller.BaseController;
import framework.utils.JsonUtils;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {

    @RequestMapping(value = "userListUi.do", produces = "application/json;charset=utf-8")
    public String userListUiPage(
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            Model model
    ) {
        PagedResult<User> pageResult = userService.listAllByPage(pageNumber, pageSize);
        model.addAttribute("pageResult", pageResult);
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
    public String updateUser(User user) {
        int flag = userService.updateUser(user);
        return "redirect:/userController/userListUi.do";
    }

    @RequestMapping("/userRoleSetUi.do")
    public String userRoleSetUi(String userId, Model model) {
        User user = userService.getUserByUserId(userId);
        List<Role> roleList = roleService.listAllRole();
        List<UserRole> userRoleList = userRoleService.listUserRoleByUserId(userId);
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        List<String> userRoleIdList = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            userRoleIdList.add(userRole.getRoleId());
        }
        //得到现在用户已经拥有角色的角色IDList
        String userRoleIdListJson = JsonUtils.listToJson(userRoleIdList);
        model.addAttribute("userRoleList", userRoleIdListJson);
        return "view/frame/user/userRole";
    }

    @RequestMapping("/updateUserRole.do")
    public String updateUserRole(String userId, String[] roleId) {
        List<String> roleIdList = new ArrayList<>(Arrays.asList(roleId));
        int flag = userRoleService.changeUserRole(userId, roleIdList);
        return "redirect:/userController/userListUi.do";
    }

    @RequestMapping("/deleteUserList.do")
    public String deleteUserList(@RequestParam("idList[]") List<String> idList) {
        for (String id : idList) {
            userService.deleteUser(id);
        }
        return "redirect:/userController/userListUi.do";
    }
}
