package com.ticket.loginandregister.controller;

import com.ticket.loginandregister.bean.JsonBean;
import com.ticket.loginandregister.bean.UserBean;
import com.ticket.loginandregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/users")
@SessionAttributes("user")
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
            UserBean userBean = userService.login(tel,token);
            if(userBean!=null){
            //  String log = "登陆成功,登陆者为："+tel;
            model.addAttribute("user",userBean);
            String s = new String("登陆成功");
            jsonBean.setCode(1);
            jsonBean.setMessage(s);
            return jsonBean;
    }
    else {
//        String log = "登陆失败,登陆者为："+tel;

        String s = new String("验证码输入错误");
        jsonBean.setCode(1);
        jsonBean.setMessage(s);
        return jsonBean;
    }
}

}
