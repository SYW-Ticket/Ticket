package com.ticket.UserInfo.util;

/**
 * Created by Shinelon on 2018/5/15.
 */
public class SystemConfig {

    /**
     * 修改密码的短信信息状态码
     *
     */
    public final static class Userinfo {

        /**
         * 对比成功状态码
         */
        public  static final int CODE_SUCCESS=1;
        public static  final  String MSG_SUCCESS="状态码匹配";



        /**
         * 对比失败状态码
         */
        public static  final int CODE_FAIL=2;
        public static  final String MSG_FAIL="状态码不匹配";


        }

    /**
     *
     * 修改密码的状态
     *
     */
    public final static class UserinfoPassword{


        /**
         * 修改成功
         */
        public  static final int CODEPASSWORD_SUCCESS=1;
        public static  final  String MSGPASSWORD_SUCCESS="修改成功";



        /**
         * 新旧密码相同
         */
        public  static final int CODEPASSWORD_FALSE=2;
        public static  final  String MSGPASSWORD_FALSE="新旧密码相同";


    }


}
