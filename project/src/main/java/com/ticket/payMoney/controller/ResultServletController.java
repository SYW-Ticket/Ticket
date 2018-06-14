package com.ticket.payMoney.controller;

import com.ticket.payMoney.service.ResultService;
import com.ticket.payMoney.utils.PayCommonUtil;
import com.ticket.payMoney.utils.PayConfigUtil;
import com.ticket.payMoney.utils.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

/**
 * Created by Shinelon on 2018/6/13.
 */
@Controller
@RequestMapping("/payment")
public class ResultServletController {
    @Autowired
    ResultService resultService;

    @RequestMapping("/test2")
    public void resultTest(HttpServletRequest req, HttpServletResponse resp){
        try {
            resultService.weixin_notify(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
