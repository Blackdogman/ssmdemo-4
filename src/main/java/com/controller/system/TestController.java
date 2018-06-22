package com.controller.system;

import com.dao.system.MailMapper;
import com.model.system.Mail;
import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/testController")
public class TestController extends BaseController {
    @Autowired
    private MailMapper mailMapper;

    @RequestMapping("/getArray.do")
    public String getArray(@RequestParam("idList[]") List<String> idList){
        for (String id:
             idList) {
            System.out.println("id：" + id);
        }
        return null;
    }

    @RequestMapping("/mail.do")
    public String mail(){
        Mail mail = new Mail();
        mail.setMailId(PrimaryKeyUtil.getPrimaryKey());
        mail.setFromUserId("12313");
        mail.setToUserId("13123213");
        mail.setCreateTime(new Date());
        mail.setFlag("0");
        mail.setMailSubject("这是Subject");
        mail.setMailContent("这是content");
        mailMapper.insert(mail);

        Mail mailReturn = mailMapper.selectByPrimaryKey("95af0c01-4323-41fe-8f17-f5b916cad565");
        System.out.println(mailReturn);
        return null;
    }
}
