package com.controller.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.system.User;
import com.service.UserService;

import framework.utils.PrimaryKeyUtil;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/login.do")
	public String login(Model model, User user)  {
		User reUser = userService.getUserByLoginNameAndPassword(user);
		if(reUser == null) {
			model.addAttribute("loginErrorMessage", "您登录信息有误，请重新输入");
			return "login.jsp";
		}else {
			model.addAttribute("loginUser", reUser);
			return "view/main";
		}
	}
	
	@RequestMapping("/userList.do")
	public String goToUserListPage(Model model) {
		List<User> userList = userService.listAllUser();
		model.addAttribute("userList", userList);
		return "view/system/userList";
	}
	
	@RequestMapping("/addUser.do")
	public String addUser(User user, Model model) {
		user.setUserId(PrimaryKeyUtil.getPrimaryKey());
		user.setPassword("123");
		user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		int flag = userService.addUser(user);
		if(flag > 0) {
			return 	"redirect:/userController/userList.do";
		}else {
			model.addAttribute("addErrorMessage", "插入失败，请检查");
			return "view/system/userAdd";
		}
	}
	
	@RequestMapping("/deleteUser.do")
	public String deleteUser(String userId, Model model) {
		userService.deleteUserByUserId(userId);
		return 	"redirect:/userController/userList.do";
	}
	
	@RequestMapping("/updateUserUi.do")
	public String updateUserUi(String userId, Model model) {
		User user = userService.getUserByUserId(userId);
		model.addAttribute("user", user);
		return "view/system/userUpdate";
	}
	
	@RequestMapping("/updateUser.do")
	public String updateUser(User user) {
		int flag = userService.updateUser(user);
		if(flag > 0) {
			return 	"redirect:/userController/userList.do";
		}else {
			return "redirect:/userController/updateUserUi.do?userId =" + user.getUserId();
		}
		
	}
}
 