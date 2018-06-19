package com.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/testController")
public class TestController {
    @RequestMapping("/getArray.do")
    public String getArray(@RequestParam("idList[]") List<String> idList){
        for (String id:
             idList) {
            System.out.println("id：" + id);
        }
        return null;
    }
}
