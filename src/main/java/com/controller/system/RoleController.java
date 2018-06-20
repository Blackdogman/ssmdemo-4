package com.controller.system;

import com.model.system.*;
import com.service.system.RoleService;
import framework.controller.BaseController;
import framework.utils.JsonUtils;
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
@RequestMapping("/roleController")
public class RoleController extends BaseController {

    @RequestMapping("/roleListUi.do")
    public String roleListUi(Model model){
        List<Role> roleList = roleService.listAllRole();
        model.addAttribute("roleList", roleList);
        return "view/frame/role/roleList";
    }

    @RequestMapping("/addRole.do")
    public String addRole(Role role){
        role.setRoleId(PrimaryKeyUtil.getPrimaryKey());
        role.setCreateTime(new Date());
        int flag = roleService.addRole(role);
        return "redirect:/roleController/roleListUi.do";
    }

    @RequestMapping("/deleteRole.do")
    public String deleteRole(String roleId){
        int flag = roleService.deleteRole(roleId);
        return "redirect:/roleController/roleListUi.do";
    }

    @RequestMapping("/updateRoleUi.do")
    public String updateRoleUi(String roleId, Model model){
        Role role =  roleService.getRoleByRoleId(roleId);
        model.addAttribute("role", role);
        return "view/frame/role/roleUpdate";
    }

    @RequestMapping("/updateRole.do")
    public String updateRole(Role role){
        int flag = roleService.updateRole(role);
        return "redirect:/roleController/roleListUi.do";
    }

    @RequestMapping("/roleMenuSetUi.do")
    public String roleMenuSetUi(String roleId, Model model){
        Role role = roleService.getRoleByRoleId(roleId);
        List<Menu> menuList = menuService.listAllMenu();
        List<RoleMenu> roleMenuList = roleMenuService.listRoleMenuByRoleId(roleId);
        model.addAttribute("role", role);
        model.addAttribute("menuList", menuList);
        List<String> roleMenuIdList = new ArrayList<>();
        for(RoleMenu roleMenu : roleMenuList){
            roleMenuIdList.add(roleMenu.getMenuId());
        }
        //得到现在用户已经拥有角色的角色IDList
        String roleMenuIdListJson = JsonUtils.listToJson(roleMenuIdList);
        model.addAttribute("roleMenuIdListJson", roleMenuIdListJson);
        return "view/frame/role/roleMenu";
    }

    @RequestMapping("/updateRoleMenu.do")
    public String updateRoleMenu(String roleId, String[] menuId){
        List<String> menuIdList = new ArrayList<>(Arrays.asList(menuId));
//        int flag = userRoleService.changeUserRole(userId, roleIdList);
        int flag = roleMenuService.changeRoleMenu(roleId, menuIdList);
        return "redirect:/roleController/roleListUi.do";
    }
}
