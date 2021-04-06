package stu.wbw.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stu.wbw.pojo.User;
import stu.wbw.service.UserService;

import java.util.List;

/**
 * User 控制器
 */
@Controller
@RequestMapping("/admin")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/listUser")
	public String list(Model model) {
		List<User> users = userService.queryAllUser();
		model.addAttribute("users", users);
		return "admin/listUser";
	}

	@RequestMapping("/editUser")
	public String edit(Model model, Integer id) {
		User user = userService.queryUserById(id);
		model.addAttribute("user", user);
		return "admin/editUser";
	}

	@RequestMapping("/updateUser")
	public String update(User user) {
		userService.updateUser(user);
		return "redirect:listUser";
	}
	@RequestMapping("/deleteUser")
	public String delete(Integer id){
		userService.deleteUserById(id);
		return "redirect:listUser";
	}
	@RequestMapping("/toAddUser")
	public String toAdd(){
		return "admin/toAddPage";
	}

	@RequestMapping("/addUser")
	public String add(User user){
		userService.addUser(user);
		return "redirect:listUser";
	}
}
