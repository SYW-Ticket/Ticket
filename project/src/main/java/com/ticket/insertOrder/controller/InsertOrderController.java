package com.ticket.insertOrder.controller;

import com.ticket.insertOrder.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/insertOrder")
public class InsertOrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/getOrder")
    @ResponseBody
    public String getOrder(@RequestParam("ticket_num") int ticket_num,@RequestParam("total_price") double total_price,
                           @RequestParam("user_id") int user_id, @RequestParam("platon_id")int platon_id,
                           @RequestParam("seat_ids")int[] seat_ids, Model model){
        System.out.println(ticket_num+"==="+total_price+"==="+user_id+"==="+platon_id);
        model.addAttribute("order",orderService.insertOrder(ticket_num,total_price,user_id,platon_id,seat_ids));
        return "1111";
    }
}
