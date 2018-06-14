package com.ticket.loginandregister.controller;

import com.ticket.loginandregister.bean.JsonBean;
import com.ticket.loginandregister.bean.UserBean;
import com.ticket.loginandregister.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.security.auth.Subject;

@Controller
@RequestMapping(value = "/users")
public class UserController {

@Autowired
UserService userService;

@ResponseBody
@RequestMapping("/sendMsg")
public Object sendMsg(String tel){
    userService.SendMessage(tel);
    String s = new String("短信已发送");
    JsonBean jsonBean = new JsonBean();
    jsonBean.setCode(0);
    jsonBean.setMessage(s);
    return jsonBean;
}

@ResponseBody
@RequestMapping("/login")
    public Object login(String tel, String token, Model model){
            JsonBean jsonBean = new JsonBean();

    try {
                userService.login(tel,token);
                jsonBean.setMessage("登陆成功");
                jsonBean.setCode(1);
                return jsonBean;
          }
          catch (IncorrectCredentialsException e){
              jsonBean.setMessage("登陆失败,验证码错误");
              jsonBean.setCode(2);
              return jsonBean;
          }
}
    @RequestMapping("/logout")
    public String login(SessionStatus sessionStatus){
            sessionStatus.setComplete();
            return "/login";
    }
}
