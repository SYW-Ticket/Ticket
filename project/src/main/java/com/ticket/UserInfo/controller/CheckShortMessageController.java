package com.ticket.UserInfo.controller;

import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.redis.IRedis;
import com.ticket.UserInfo.util.JsonResult;
import com.ticket.UserInfo.util.JsonTools;
import com.ticket.UserInfo.util.MyselfException.EqualsException;
import com.ticket.UserInfo.util.MyselfException.YangException;
import com.ticket.UserInfo.util.ShortMessageUtil;
import com.ticket.UserInfo.util.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Shinelon on 2018/6/6.
 */
@Controller
@RequestMapping("/UserInfo")
public class CheckShortMessageController {
    @Autowired
    private IRedis redis;

    @Autowired
    private IUserInfoService userInfoService;

    /**
     *  若捕获从UserInfoService抛出的自定义异常则为比对失败   返回json对象
     * @param ShortMessage
     * @param model
     * @return
     */
    @RequestMapping("/CheckShortmessage")
    @ResponseBody
    public Object CheckShortMessage(String ShortMessage,String tel,Model model){
        System.out.println("============================");
        //输入的验证码ShortMessage  和发送的手机验证码是否相等
        boolean flag = false;
        try {
           userInfoService.CheckMessage(ShortMessage,tel);
            JsonResult jsonResult = JsonTools.formJsonResult(SystemConfig.Userinfo.CODE_SUCCESS
                    , SystemConfig.Userinfo.MSG_SUCCESS);

            //返回json对象
            return jsonResult;

        } catch (YangException e) {
            e.printStackTrace();
            JsonResult jsonResult = JsonTools.formJsonResult(SystemConfig.Userinfo.CODE_FAIL
                    , SystemConfig.Userinfo.MSG_FAIL);

            //返回json对象
            return jsonResult;
        }

    }
    /**
     *   发送验证码
     * @param tel
     * @param model
     */
    @ResponseBody
    @RequestMapping("/sendMessage")
    public void sendMessage(String tel,Model model){

        System.out.println("发送信息");
        //获取短信验证码 的内容（随机数）
        String pwd = ShortMessageUtil.bytes2hex();

        //将短信验证码信息放入redis中
        redis.saveString(tel,pwd);

        //调用service层的发送验证码功能模块
        userInfoService.sendMessage(pwd,tel);
    }

    /**
     *   修改密码
     * @param tel
     * @param pws
     * @param model
     * @return
     */
    @RequestMapping("/ModeifyPassword")
    @ResponseBody
    public Object ModifyPasswodController(String tel,String pws,Model model){
        try {
            userInfoService.ModifyPasswordService(tel,pws);
            JsonResult jsonResult = JsonTools.formJsonResult(SystemConfig.UserinfoPassword.CODEPASSWORD_SUCCESS
                    , SystemConfig.UserinfoPassword.MSGPASSWORD_SUCCESS);
            return jsonResult;
        } catch (EqualsException e) {
            JsonResult jsonResult = JsonTools.formJsonResult(SystemConfig.UserinfoPassword.CODEPASSWORD_FALSE
                    , SystemConfig.UserinfoPassword.MSGPASSWORD_FALSE);
            e.printStackTrace();
            return jsonResult;
        }


    }










}
