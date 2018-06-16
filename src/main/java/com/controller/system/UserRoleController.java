package com.controller.system;

import com.service.system.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userRoleController")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
}
