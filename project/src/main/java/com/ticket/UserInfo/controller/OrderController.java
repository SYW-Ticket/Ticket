package com.ticket.UserInfo.controller;

import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.UserInfoService.deleteService.RemoveJob;
import com.ticket.UserInfo.redis.IRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shinelon on 2018/6/11.
 */
@Controller
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private IRedis redis;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private RemoveJob removeJob;


}
