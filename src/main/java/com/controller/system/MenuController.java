package com.controller.system;

import com.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menuController")
public class MenuController {
    @Autowired
    private MenuService menuService;

}
