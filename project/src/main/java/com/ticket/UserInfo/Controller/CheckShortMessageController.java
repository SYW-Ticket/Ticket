package com.ticket.UserInfo.Controller;

import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.util.JsonResult;
import com.ticket.UserInfo.util.JsonTools;
import com.ticket.UserInfo.util.SystemConfig;
import com.ticket.UserInfo.util.MyselfException.YangException;
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



}
