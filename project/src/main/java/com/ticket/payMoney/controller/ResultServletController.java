package com.ticket.payMoney.controller;

import com.ticket.payMoney.utils.PayCommonUtil;
import com.ticket.payMoney.utils.PayConfigUtil;
import com.ticket.payMoney.utils.XMLUtil;
import org.springframework.stereotype.Controller;
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
@RequestMapping("payment")
public class ResultServletController {


    @RequestMapping("test2")
    public void  resultTest(HttpServletRequest req, HttpServletResponse resp){
        try {
            weixin_notify(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     *
     * 解析微信支付结果
     *
     *
     */
    public void weixin_notify(HttpServletRequest request, HttpServletResponse
            response) throws Exception{
        //因为没有重定向，所以测试时无法知道支付结果，因此将支付结果写入文件，开发时访问文件查看，
        String writeContent="支付失败";

        //保存文件位置
        /*String path = request.getServletContext().getRealPath("file");*/

       /* File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path+"/result.txt", true);   //实际开发中删除由此处到上面的内容*/


        //读取参数
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s ;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream,
                "UTF-8"));
        while ((s = in.readLine()) != null){
            sb.append(s);
        }
        in.close();
        inputStream.close();

        //解析xml成map
        Map<String, String> m = new HashMap<String,String>();
        m = XMLUtil.doXMLParse(sb.toString());

        //过滤空  设置TreeMap
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            String parameterValue = m.get(parameter);
            String v = "";
            if(null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }

        //账号信息
        String key = PayConfigUtil.API_KEY; // key


        System.err.println(packageParams);
        String out_trade_no = (String)packageParams.get("out_trade_no");  //当单号，实际开发中应在下面的if中除非对每个订单支付结果做记录

        //判断签名是否正确
        if(PayCommonUtil.isTenpaySign("UTF-8", packageParams,key)) {


            //处理业务================================================================

            String resXml = "";
            if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
                //这里已经支付成功
                //////////执行自己的业务逻辑/////////////
                String mch_id = (String) packageParams.get("mch_id");
                String openid = (String) packageParams.get("openid");
                String is_subscribe = (String) packageParams.get("is_subscribe");
                // String out_trade_no = (String)packageParams.get("out_trade_no");
                String total_fee = (String) packageParams.get("total_fee");
                System.err.println("mch_id:" + mch_id);
                System.err.println("openid:" + openid);
                System.err.println("is_subscribe:" + is_subscribe);
                System.err.println("out_trade_no:" + out_trade_no);
                System.err.println("total_fee:" + total_fee);


                System.out.println("=======================================================================================");

                //////////执行自己的业务逻辑/////////////

                //需要在执行支付二维码之前将orderId设置到request中 此处才可以去除
                String id1 = request.getParameter("orderId");

                int id = Integer.parseInt(id1);

                //手写JDBC
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.58.93:3306/ticket?useUnicode=true&amp;characterEncoding=utf-8&useSSL=false", "root", "123456");

                PreparedStatement ps = conn.prepareStatement("update f_order set cost_state='1' where id=?;");
                ps.setInt(1,id);




                System.err.println("支付成功");

                writeContent = "订单" + out_trade_no + "支付成功";   //拼接支付结果信息，写入文件中，实际开发删除


                //通知微信 异步确认成功 必写  不然无法通知后台  八次之后认为交易失败
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";

            } else {
                writeContent = "订单" + out_trade_no + "支付失败，错误信息" +
                        packageParams.get("err_code");//拼接支付结果信息，写入文件中，实际开发删除


                System.err.println("订单" + out_trade_no + "支付失败，错误信息" +
                        packageParams.get("err_code"));


                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[ಸ෈ԅᑮ]]></return_msg>" + "</xml>";
            }


            //______________________________________
            //业务处理完毕
            //------------------------------------------
            BufferedOutputStream out = new BufferedOutputStream(
                    response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        }else{
            writeContent = "订单"+out_trade_no+"通知签名失败，支付失败";//拼接支付结果信息，写入文件中，实际开发删除


            System.err.println("通知签名失败，支付失败");
        }

     /*   fileOutputStream.write(writeContent.getBytes());//将支付结果信息，写入文件中，实际开发删除


        fileOutputStream.close();//将支付结果信息，写入文件中，实际开发删除*/
    }

}
