package com.ticket.UserInfo.controller;

import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.UserInfoService.deleteService.RemoveJob;
import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.redis.IRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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


    /**
     *  查询未支付订单
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/unpay")
    public String SelectUnpayOrder(int userId, Model model){

        Order order = userInfoService.findUnPayOrder(userId);

        Model orders = model.addAttribute("orders", order);

        return "##############";
    }

    /**
     * 查询历史订单
     */
    @RequestMapping("/History")
    public String SelectHistoryOrder(int userId,Model model){
        List<Order> orderList = userInfoService.HistoryorderList(userId);

        Model orderList1 = model.addAttribute("orderList", orderList);


        return "#############";
    }


}
