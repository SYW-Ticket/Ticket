package com.ticket.UserInfo.controller;

import com.google.gson.Gson;
import com.ticket.UserInfo.UserInfoService.IUserInfoService;
import com.ticket.UserInfo.UserInfoService.deleteService.RemoveJob;
import com.ticket.UserInfo.bean.Order;
import com.ticket.UserInfo.redis.IRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public Object SelectUnpayOrder(int userId, Model model){

        Order order = userInfoService.findUnPayOrder(userId);

        Model orders = model.addAttribute("orders", order);

        return order;
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


    /**
     *  支付订单（微信）
     */
    @RequestMapping("/allSeatsByPId/{UserId}")
    public String SelectOrderPay(@PathVariable("UserId") int UserId, Model model){
        String userId = "order_"+UserId;

        String valueByKey = redis.getValueByKey(userId);

        Gson gson = new Gson();

        Order order = gson.fromJson(valueByKey, Order.class);


        Model orderList2 = model.addAttribute("orderList2", order);

        return "###############";

    }



    /**
     *  支付订单2（微信）
     */
    @RequestMapping("/allSeatsByPId2/{UserId}")
    public String SelectOrderPay2(@PathVariable("UserId") int UserId, Model model){
        String id = "order_"+UserId;

        String value = redis.getValueByKey(id);

        Gson gson = new Gson();

        Order order2 = gson.fromJson(value, Order.class);


        Model orderList2 = model.addAttribute("orderList3", order2);

        return "###############";
    }


}
