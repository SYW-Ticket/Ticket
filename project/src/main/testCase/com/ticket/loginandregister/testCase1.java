package com.ticket.loginandregister;

import com.ticket.UserInfo.util.ShortMessageUtil;
import com.ticket.insertOrder.bean.Order;
import com.ticket.insertOrder.daoWrite.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shinelon on 2018/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class testCase1 {

    @Autowired
    OrderDao orderDao;

    @Test
    public void  testCase1(){


        long x = TimeUnit.MINUTES.toSeconds(20);
        System.out.println(x);
    }

    @Test
    public void testCase2(){
        Order order = new Order();
        order.setCostState(0);
        order.setOrderTime(new Date());
        order.setPlatoonId(1);
        order.setTicketNum(2);
        order.setUserId(1);
        order.setTotalPrice(2000);
        orderDao.insertOrder(order);
        System.out.println(order.getId());
    }
}
