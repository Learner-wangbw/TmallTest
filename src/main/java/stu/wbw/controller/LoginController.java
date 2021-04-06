package stu.wbw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import stu.wbw.pojo.User;
import stu.wbw.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * 登录注销注册控制器
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    //登录
    @RequestMapping("/login")
    public String login(Model model,
                        @RequestParam("name") String name,
                        @RequestParam("password") String password,
                        HttpSession session){
        User user = userService.queryUserByNameAndPwd(name, password);
        if (null == user){
            model.addAttribute("msg","账号密码有误，请重新输入！");
            return "loginPage";
        }
        session.setAttribute("user",user);
        return "redirect:home";
    }

    //注销
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:home";
    }

    //注册
    @RequestMapping("/register")
    public String register(Model model,User user){
        String name = user.getName();
        boolean exist = userService.isExist(name);
        if (exist) {
            String msg = "用户名已存在。请更换！";
            model.addAttribute("msg", msg);
            model.addAttribute("username", user.getName());
            return "registerPage";
        }
        userService.addUser(user);
        return "redirect:registerSuccessPage";
    }

    //检测用户是否登录
    @RequestMapping("/checkLogin")
    @ResponseBody
    public String checkLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null != user)
            return "success";
        return "fail";
    }
}
