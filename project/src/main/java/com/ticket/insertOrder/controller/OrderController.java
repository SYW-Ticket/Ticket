package com.ticket.insertOrder.controller;

import com.ticket.UserInfo.bean.Order;
import com.ticket.insertOrder.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/insertOrder")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/getOrder")
    public String getOrder(int ticket_num, int price, int user_id, int platon_id, int[] seat_ids, Model model){
        model.addAttribute("order",orderService.insertOrder(ticket_num,price,user_id,platon_id,seat_ids));
        return "/";
    }
}
