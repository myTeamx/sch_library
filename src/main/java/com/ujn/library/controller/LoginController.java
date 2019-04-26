package com.ujn.library.controller;

import com.ujn.library.service.UserService;
import com.ujn.library.util.SessionMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String name, String password, HttpServletRequest request) throws Exception {
        boolean isLogin = userService.login(name, password, request);
        // 登录成功
        if (isLogin) {
            return "yes";
        } else { // 登录失败
            return "用户名/密码错误";
        }
    }

    @RequestMapping(value = "/saveName.action", method = RequestMethod.GET)
    public String saveName() throws Exception {
        return "/index";
    }

    @GetMapping(value = "/logout.action")
    public String logout(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        SessionMap.sessionMap.remove(username); // 移除session
        session.invalidate(); // 销毁session
        return "/login";
    }


}
