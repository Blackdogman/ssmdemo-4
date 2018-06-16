package com.controller.system;

import com.model.system.Role;
import com.service.system.RoleService;
import framework.utils.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/roleController")
public class RoleController {
    @Autowired
    private RoleService roleService;

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
}
