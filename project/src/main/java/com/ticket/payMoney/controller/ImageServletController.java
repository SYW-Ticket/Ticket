package com.ticket.payMoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Shinelon on 2018/6/13.
 */
@Controller
@RequestMapping("payment")
public class ImageServletController {

    @RequestMapping("image")
    public void DrawIMG(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedImage image = (BufferedImage)req.getSession().getAttribute("image");//存放二维码

        if (image != null) {
            ImageIO.write(image, "JPEG", resp.getOutputStream());  //发送到页面上
            System.out.println("erweimafasong=============================");
        }
    }


}
