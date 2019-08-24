package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author miion
 * @create 2019-07-21 15:59
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        User login = userService.login(username, password);
        if(login!=null){

            session.setAttribute("user",login);
            return "forward:/file/findAll";
        }else{
            return "login";
        }

    }

}
