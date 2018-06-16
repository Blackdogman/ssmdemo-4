package com.controller.system;

import com.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roleController")
public class RoleController {
    @Autowired
    private RoleService roleService;
}
