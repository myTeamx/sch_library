package com.ujn.library.service.impl;

import com.ujn.library.dao.UserMapper;
import com.ujn.library.service.UserService;
import com.ujn.library.util.SessionMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(String name, String password, HttpServletRequest request) throws Exception {
        String pwd = userMapper.getPasswordByName(name);
        Map<String, HttpSession> sessionMap = SessionMap.sessionMap;
        if (password.equals(pwd)) {
            boolean logined = sessionMap.containsKey(name);
            if (logined) { // 如果已经登陆，就把之前登录的session去除，并且销毁
                HttpSession session = sessionMap.remove(name);
                session.invalidate();
            }
            // 将name放入session
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            // 然后加入新的
            sessionMap.put(name, session);
            return true;
        }
        return false;
    }
}
