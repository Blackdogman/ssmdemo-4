package com.controller.system;

import com.model.system.Mail;
import com.model.system.User;
import framework.controller.BaseController;
import framework.utils.PrimaryKeyUtil;
import framework.utils.pageUtil.PagedResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mailController")
public class MailController extends BaseController {
    @RequestMapping("/mailSendUi.do")
    public String mailSendUi(Model model) {
        List<User> userList = userService.listAllUser();
        model.addAttribute("userList", userList);
        return "view/frame/mail/mailSend";
    }

    @RequestMapping("/mailSend.do")
    public String mailSend(Mail mail, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        mail.setMailId(PrimaryKeyUtil.getPrimaryKey());
        mail.setFlag("1");
        mail.setFromUserId(user.getUserId());
        mail.setCreateTime(new Date());
        int flag = mailService.sendMail(mail);
        return "redirect:/mailController/mailSendHistoryUi.do";
    }

    @RequestMapping(value = "/mailSendHistoryUi.do", produces = "application/json;charset=utf-8")
    public String mailSendHistoryUi(HttpSession session, Model model,
                                    @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        User user = (User) session.getAttribute("loginUser");
        PagedResult<Mail> pageResult = mailService.listAllMailByFromUserId(user.getUserId(),pageNumber,pageSize);
        model.addAttribute("pageResult", pageResult);
        return "view/frame/mail/mailList";
    }
}
