package com.ticket.payMoney.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * Created by Shinelon on 2018/6/12.
 */
public class MD5Util {
    /**
     * 编码  将字符串数组转成可识别的字符串
     */

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 转换成自己可识别的字符串
     */
    private static String byteToHexString(byte b) {
        int n=b;
        if (n<0){
            n+=256;
        }
        int d1=n/16;
        int d2=n%16;
        return hexDigits[d1] + hexDigits[d2];
    }


    /**
     * 指定内容的MD5 值
     *
     * orgin 被转换的内容
     *
     * charSetingname  字符集
     */
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)){
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return resultString;
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5","6", "7", "8", "9", "a", "b", "c", "d", "e","f"};

    public static String UrlEncode(String src) throws UnsupportedEncodingException {
        return URLEncoder.encode(src, "UTF-8").replace("+", "%20");
    }
}


