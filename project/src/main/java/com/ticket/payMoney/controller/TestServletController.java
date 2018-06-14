package com.ticket.payMoney.controller;

import com.ticket.payMoney.utils.PayCommonUtil;
import com.ticket.payMoney.utils.ZxingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
/**
 * Created by Shinelon on 2018/6/13.
 */
@Controller
@RequestMapping("/payment")
public class TestServletController {


    Random random = new Random();

    @RequestMapping("/test")
    public void beginTest(@RequestParam("body") String body, HttpServletRequest req, Model model, HttpServletResponse response)throws ServletException, IOException {
        System.out.println("jinrutestControllerfangfa=============");
        req.setCharacterEncoding("UTF-8");
        String price = "1";//默认是1分钱
//        String body = req.getParameter("body");//商品描述，获取用户想买的东西
//        if (req.getMethod().equalsIgnoreCase("get")) {
//            body = new String(body.getBytes("ISO8859-1"), "UTF-8");
//        }
        String orderId = random.nextInt(100000000) + "";  //此处生成随机为订单
        try {
            String url = PayCommonUtil.weixin_pay(price, body, orderId);//获取微信返回的二维码对应的短地址
            BufferedImage image = ZxingUtil.createImage(url, 300, 300); //将地址转换成二维码图片
            model.addAttribute("oid",orderId);
//            req.getSession().setAttribute("oid", orderId);   //将订单写入session，页面显示使用
//            model.addAttribute("image",image);
            ImageIO.write(image,"jpg",response.getOutputStream());
//            req.getSession().setAttribute("image", image); //将图片放入session中
            /*resp.sendRedirect("/payment/payment.jsp");*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
