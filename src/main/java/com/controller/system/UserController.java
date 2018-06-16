package com.controller.system;

import com.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;
}
