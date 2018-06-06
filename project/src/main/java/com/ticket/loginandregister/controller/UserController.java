package com.ticket.loginandregister.controller;

import com.ticket.loginandregister.bean.UserBean;
import com.ticket.loginandregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("user")
public class UserController {

@Autowired
UserService userService;

@ResponseBody
@RequestMapping("/sendMsg")
public String sendMsg(String tel){
    userService.SendMessage(tel);
    return "短信已发送";
}


@ResponseBody
@RequestMapping("/login")
    public String login(String tel, String token, Model model){
    if(userService.login(tel,token)!=null){
            UserBean userBean = userService.login(tel,token);
//            String log = "登陆成功,登陆者为："+tel;
            model.addAttribute("user",userBean);
            return "登陆成功";
    }
    else {
//        String log = "登陆失败,登陆者为："+tel;
        return "验证码输入错误";
    }
}

}
