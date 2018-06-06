package com.ticket.loginandregister.util;

import java.util.Random;

/**
 * Created by Shinelon on 2018/6/6.
 */

public class ShortMessageUtil {

    private static String simpl="123456789ABCDEF";


    public static String  bytes2hex() {
        StringBuffer sb = new StringBuffer();

        //随机数
        Random random=new Random();
        //设置随机数写出验证码
        char[] codechar=new char[5];

        int bound=simpl.length();

        for(int i=0;i<=4;i++) {
            //产生随机数
            int index=random.nextInt(bound);

            char c=simpl.charAt(index);

            sb.append(c);

        }
        String s = sb.toString();
        System.out.println(s);
        return sb.toString();
    }


}
