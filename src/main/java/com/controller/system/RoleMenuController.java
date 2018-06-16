package com.controller.system;

import com.service.system.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roleMenuController")
public class RoleMenuController {
    @Autowired
    private RoleMenuService roleMenuService;
}
