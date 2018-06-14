package com.ticket.insertOrder.controller;

import com.ticket.UserInfo.bean.Order;
import com.ticket.insertOrder.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/insertOrder")
public class InsertOrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/getOrder")
    public String getOrder(@RequestParam("ticket_num") int ticket_num,@RequestParam("total_price") double total_price,@RequestParam("user_id") int user_id,@RequestParam("platon_id") int platon_id,@RequestParam("seat_ids") int[] seat_ids, Model model){
//        try {
            model.addAttribute("order",orderService.insertOrder(ticket_num,total_price,user_id,platon_id,seat_ids));
//        } catch (RuntimeException e) {
//            //事物回滚处理
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            System.out.println("已回滚");
//            //异常页面
//            return "/";
//        }
        return "/makeSure";
    }
}
