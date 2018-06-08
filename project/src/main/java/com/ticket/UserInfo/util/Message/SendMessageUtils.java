package com.ticket.UserInfo.util.Message;


import com.ticket.UserInfo.util.ShortMessageUtil;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class SendMessageUtils {

    //发送短信方法
    public static String send(String tel){
        String host = "https://feginesms.market.alicloudapi.com";
        String path = "/codeNotice";
        String method = "GET";
        String appcode = "0f68b5ecd2ea448fbbbba8dec617e5af";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        //短信的内容
        String code = ShortMessageUtil.bytes2hex();
        querys.put("param",code);
        //发送到那个手机号
        querys.put("phone", tel);
        querys.put("sign", "1");
        querys.put("skin", "1");


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());
            //获取response的body
//            System.out.println(EntityUtils.toString(response.getEntity()));
            return code;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
